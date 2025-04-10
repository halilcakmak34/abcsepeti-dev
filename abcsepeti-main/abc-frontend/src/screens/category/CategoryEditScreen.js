import React, { useEffect, useState } from 'react';
import { BACKEND_API_GATEWAY_URL } from '../../constants/appConstants';
import { Button, Col, Form, Row } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import { listCategoryDetailsAction, updateCategoryAction } from '../../actions/categoryActions';
import FormContainer from '../../components/FormContainer';
import Loader from '../../components/Loader';
import Message from '../../components/Message';
import { CATEGORY_UPDATE_RESET } from '../../constants/categoryConstants';
import { getCategories } from '../../service/RestApiCalls';
import { useTranslation } from 'react-i18next';

const CategoryEditScreen = ({ match, history }) => {
  const categoryId = match.params.id;

  const [categoryName, setCategoryName] = useState('');
  const [description, setDescription] = useState('');
  const [categories, setCategories] = useState([]);
  const [parentId, setParentId] = useState('');

  const categoryDetails = useSelector((state) => state.categoryDetails);
  const { loading, error, category } = categoryDetails;

  const dispatch = useDispatch();


  const categoryUpdate = useSelector((state) => state.categoryUpdate);
  const { loading: loadingUpdate, error: errorUpdate, success: successUpdate } = categoryUpdate;

  const { t, i18n } = useTranslation(['translation', 'welcome']);


  useEffect(async () => {
    await getCategories().then((res) => {
      setCategories(res);
    });
  }, [category]);

  useEffect(() => {
    if (successUpdate) {
      dispatch({ type: CATEGORY_UPDATE_RESET });
      history.push('/admin/category/categoryList');
    } else {
      if (!category?.categoryName || category?.categoryId !== categoryId) {
        dispatch(listCategoryDetailsAction(categoryId));
      } else {
        setParentId(category.parentId);
        setCategoryName(category.categoryName);
        setDescription(category.description);
      }
    }
  }, [dispatch, history, categoryId, category, successUpdate]);


  const submitHandler = (e) => {
    dispatch(
      updateCategoryAction({
        categoryId,
        parentId,
        categoryName,
        description
      })
    );
  };

  return (
    <>
      <Link to='/admin/category/categorylist' className='btn btn-dark my-3'>
        {t('welcome:categoryEdit.go.back')}
      </Link>
      <h1>{t('welcome:categoryEdit.edit.category')}</h1>
      <hr></hr>
      {loadingUpdate && <Loader />}
      {errorUpdate && <Message variant='danger'>{errorUpdate}</Message>}
      {loading ? (
        <Loader />
      ) : error ? (
        <Message variant='danger'>{error}</Message>
      ) : (
        <>
          <Row>

            <Col>
              <Form.Group controlId='parentId'>
                <Form.Label>{t('welcome:categoryEdit.category')}</Form.Label>
                <Form.Control as='select' value={parentId} required onChange={(e) => setParentId(e.target.value)}>
                  <option value='0'>{t('welcome:categoryEdit.select.category')}  </option>
                  {categories.length > 0 &&
                    categories.map((category) => {
                      return (
                        <option key={category.categoryId} value={category.categoryId}>
                          {category.categoryName}
                        </option>
                      );
                    })}
                </Form.Control>
              </Form.Group>
              <Form.Group controlId='name'>
                <Form.Label>{t('welcome:categoryEdit.name')}</Form.Label>
                <Form.Control
                  type='name'
                  placeholder={t('welcome:categoryEdit.enter.name')}
                  value={categoryName}
                  onChange={(e) => setCategoryName(e.target.value)}
                ></Form.Control>
              </Form.Group>

              <Form.Group controlId='description'>
                <Form.Label>{t('welcome:categoryEdit.description')}</Form.Label>
                <Form.Control
                  type='text'
                  placeholder={t('welcome:categoryEdit.enter.description')}
                  value={description}
                  onChange={(e) => setDescription(e.target.value)}
                ></Form.Control>
              </Form.Group>
            </Col>
          </Row>
          <Row className='m-5 justify-content-md-center'>
            <Button type='submit' variant='primary' onClick={submitHandler}>
              {t('welcome:categoryEdit.update')}
            </Button>
          </Row>
        </>
      )}
    </>
  );
};

export default CategoryEditScreen;
