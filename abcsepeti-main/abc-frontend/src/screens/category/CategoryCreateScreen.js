import React, { useEffect, useState } from 'react';
import { Button, Col, Form, Row } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import Loader from '../../components/Loader';
import Message from '../../components/Message';
import { getAllCategoriesApi, getCategories } from '../../service/RestApiCalls';
import { createCategoryAction } from '../../actions/categoryActions';
import { Trans, useTranslation } from 'react-i18next';

const CategoryCreateScreen = ({ match, history }) => {
  const categoryId = match.params.id;
  const [parentId, setParentId] = useState('');
  const [categoryName, setCategoryName] = useState('');
  const [description, setDescription] = useState('');
  const [categories, setCategories] = useState([]);
  const categoryDetails = useSelector((state) => state.categoryDetails);
  const { loading, error, category } = categoryDetails;

  const dispatch = useDispatch();
  const { t, i18n } = useTranslation(['translation', 'welcome']);
  const changeLanguage = code => {
    i18n.changeLanguage(code);
  };

  useEffect(async () => {
    await getCategories().then((res) => {
      setCategories(res);
    });
  }, [dispatch, history, categoryId, category]);

  const submitHandler = () => {
    dispatch(
      createCategoryAction({
        parentId,
        categoryName,
        description
      })
    );
    history.push('/admin/category/categorylist');
  };



  return (
    <>
      <Link to='/admin/category/categorylist' className='btn btn-dark my-3'>
        {t('welcome:categoryCreate.go.back')}
      </Link>

      <h1>{t('welcome:categoryCreate.create.category')}</h1>
      <hr></hr>
      {loading ? (
        <Loader />
      ) : error ? (
        <Message variant='danger'>{error}</Message>
      ) : (
        <>
          <Row>
            <Col>
              <Form.Group controlId='parentId'>
                <Form.Label>{t('welcome:categoryCreate.parent.category')}</Form.Label>
                <Form.Control as='select' value={parentId} required onChange={(e) => setParentId(e.target.value)}>
                  <option value='0'>{t('welcome:categoryCreate.select.parent.category')}</option>
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
                <Form.Label>{t('welcome:categoryCreate.name')}</Form.Label>
                <Form.Control
                  type='name'
                  placeholder={t('welcome:categoryCreate.enter.name')}
                  value={categoryName}
                  onChange={(e) => setCategoryName(e.target.value)}
                ></Form.Control>
              </Form.Group>

              <Form.Group controlId='description'>
                <Form.Label>{t('welcome:categoryCreate.description')}</Form.Label>
                <Form.Control
                  type='text'
                  placeholder={t('welcome:categoryCreate.enter.description')}
                  value={description}
                  onChange={(e) => setDescription(e.target.value)}
                ></Form.Control>
              </Form.Group>

            </Col>
          </Row>
          <Row className='m-5 justify-content-md-center' onClick={submitHandler}>
            <Button type='submit' variant='primary'>
              {t('welcome:categoryCreate.create.category')}
            </Button>
          </Row>
        </>
      )}
    </>
  );
};

export default CategoryCreateScreen;
