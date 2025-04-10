import React, { useEffect, useState } from 'react';
import { BACKEND_API_GATEWAY_URL } from '../constants/appConstants';
import { Button, Col, Form, Row } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import { createProductAction } from '../actions/productActions';
import FormContainer from '../components/FormContainer';
import Loader from '../components/Loader';
import Message from '../components/Message';
import { uploadImageApi, getProductCategories } from '../service/RestApiCalls';
import { useTranslation } from 'react-i18next';

const ProductCreateScreen = ({ match, history }) => {
  const productId = match.params.id;
  const [productName, setProductName] = useState('');
  const [price, setPrice] = useState(0);
  const [image, setImage] = useState('');
  const [availableItemCount, setAvailableItemCount] = useState(0);
  const [description, setDescription] = useState('');
  const [uploading, setUploading] = useState(false);
  const [productCategories, setProductCategories] = useState([]);
  const [productCategory, setProductCategory] = useState('');

  const dispatch = useDispatch();

  const productDetails = useSelector((state) => state.productDetails);
  const { loading, error, product } = productDetails;

  useEffect(async () => {
    await getProductCategories().then((res) => {
      setProductCategories(res.page.content);
    });
  }, [dispatch, history, productId, product]);

  const uploadFileHandler = async (e) => {
    const file = e.target.files[0];

    const formData = new FormData();
    formData.append('imageFile', file);
    setUploading(true);

    try {
      const config = {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      };

      const { imageId } = await uploadImageApi(config, formData);
      setImage(imageId);
      setUploading(false);
    } catch (error) {
      console.error(error);
      setUploading(false);
    }
  };

  const { t, i18n } = useTranslation(['translation', 'welcome']);

  const submitHandler = () => {
    dispatch(
      createProductAction({
        productId,
        productName,
        price,
        imageId: image,
        description,
        availableItemCount,
        productCategoryId: productCategory
      })
    );
    history.push('/admin/productlist');
  };

  return (
    <>
      <Link to='/admin/productlist' className='btn btn-dark my-3'>
        {t('welcome:productCreate.go.back')}
      </Link>

      <h1>{t('welcome:productCreate.create.product')} </h1>
      <hr></hr>
      {loading ? (
        <Loader />
      ) : error ? (
        <Message variant='danger'>{error}</Message>
      ) : (
        <>
          <Row>
            <Col md={4}>
              <Row>
                <Form.Group controlId='image'>
                  <img
                    src={`${BACKEND_API_GATEWAY_URL}/api/catalog/image/${image}`}
                    alt={image}
                    style={{ height: '400px' }}
                    fluid
                    rounded
                  ></img>
                  {uploading && <Loader />}
                </Form.Group>
                <Form.File className='mt-5 mr-4' id='image-file' label='Choose File' custom onChange={uploadFileHandler}></Form.File>
              </Row>
            </Col>
            <Col>
              <Form.Group controlId='name'>
                <Form.Label>{t('welcome:productCreate.name')} </Form.Label>
                <Form.Control
                  type='name'
                  placeholder={t('welcome:productCreate.enter.name')}
                  value={productName}
                  onChange={(e) => setProductName(e.target.value)}
                ></Form.Control>
              </Form.Group>

              <Form.Group controlId='price'>
                <Form.Label>Price</Form.Label>
                <Form.Control
                  type='number'
                  placeholder={t('welcome:productCreate.enter.price')}
                  value={price}
                  onChange={(e) => setPrice(e.target.value)}
                ></Form.Control>
              </Form.Group>

              <Form.Group controlId='countInStock'>
                <Form.Label>{t('welcome:productCreate.count.in.stock')} </Form.Label>
                <Form.Control
                  type='number'
                  placeholder={t('welcome:productCreate.enter.countInStock')}
                  value={availableItemCount}
                  onChange={(e) => setAvailableItemCount(e.target.value)}
                ></Form.Control>
              </Form.Group>

              <Form.Group controlId='description'>
                <Form.Label>Description</Form.Label>
                <Form.Control
                  type='text'
                  placeholder= {t('welcome:productCreate.enter.description')}
                  value={description}
                  onChange={(e) => setDescription(e.target.value)}
                ></Form.Control>
              </Form.Group>

              <Form.Group controlId='productCategory'>
                <Form.Label>  {t('welcome:productCreate.product.category')}</Form.Label>
                <Form.Control as='select' value={productCategory} required onChange={(e) => setProductCategory(e.target.value)}>
                  <option value='0'> {t('welcome:productCreate.select.product.category')}</option>
                  {productCategories.length > 0 &&
                    productCategories.map((pc) => {
                      return (
                        <option key={pc.productCategoryId} value={pc.productCategoryId}>
                          {pc.productCategoryName}
                        </option>
                      );
                    })}
                </Form.Control>
              </Form.Group>
            </Col>
          </Row>
          <Row className='m-5 justify-content-md-center' onClick={submitHandler}>
            <Button type='submit' variant='primary'>
              {t('welcome:productCreate.create.product')}
            </Button>
          </Row>
        </>
      )}
    </>
  );
};

export default ProductCreateScreen;
