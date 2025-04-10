import React, { useEffect } from 'react';
import { LinkContainer } from 'react-router-bootstrap';
import { Table, Button, Row, Col } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import { isAdmin } from '../../service/CommonUtils';
import Message from '../../components/Message';
import Loader from '../../components/Loader';
import { listCategoryAction, deleteCategoryAction } from '../../actions/categoryActions';
import { CATEGORY_CREATE_RESET } from '../../constants/categoryConstants';
import ReactPaginate from 'react-paginate';
import { useTranslation } from 'react-i18next';

const CategoryListScreen = ({ history, match }) => {
  const dispatch = useDispatch();

  const categoryList = useSelector((state) => state.categoryList);
  const { loading, error, categories, pageResponse } = categoryList;

  const categoryDelete = useSelector((state) => state.categoryDelete);
  const { loading: loadingDelete, error: errorDelete, success: successDelete } = categoryDelete;

  const categoryCreate = useSelector((state) => state.categoryCreate);
  const { loading: loadingCreate, error: errorCreate, success: successCreate, product: createdCategory } = categoryCreate;

  const userLogin = useSelector((state) => state.userLogin);
  const { userInfo } = userLogin;

  const { t, i18n } = useTranslation(['translation', 'welcome']);

  useEffect(() => {
    dispatch({ type: CATEGORY_CREATE_RESET });

    if (!userInfo || !isAdmin()) {
      history.push('/login');
    }
    dispatch(listCategoryAction(0));
  }, [dispatch, history, userInfo, successDelete, successCreate, createdCategory]);

  const deleteHandler = (id) => {
    if (window.confirm('Are you sure')) {
      dispatch(deleteCategoryAction(id));
    }
  };

  const createCategoryHandler = () => {
    history.push('/admin/category/create');
  };

  const handlePageClick = (data) => {
    let selected = data.selected;
    dispatch(listCategoryAction(selected));
  };

  return (
    <>
      <Row className='align-items-center'>
        <Col>
          <h1>{t('welcome:categoryList.categories')}</h1>
        </Col>
        <Col className='text-right'>
          <Button className='my-3' onClick={createCategoryHandler}>
            <i className='fas fa-plus'></i> Create Category
          </Button>
        </Col>
      </Row>
      {loadingDelete && <Loader />}
      {errorDelete && <Message variant='danger'>{errorDelete}</Message>}
      {loadingCreate && <Loader />}
      {errorCreate && <Message variant='danger'>{errorCreate}</Message>}
      {loading ? (
        <Loader />
      ) : error ? (
        <Message variant='danger'>{error}</Message>
      ) : (
        <>
          <Table striped bordered hover responsive className='table-sm'>
            <thead>
              <tr>
                <th>{t('welcome:categoryList.id')}</th>
                <th>{t('welcome:categoryList.parent.id')}</th>
                <th>{t('welcome:categoryList.category.name')} NAME</th>
                <th>{t('welcome:categoryList.description')}</th>
                <th>{t('welcome:categoryList.actions')}</th>
              </tr>
            </thead>
            <tbody>
              {categories?.map((category) => (
                <tr key={category.categoryId}>
                  <td>{category.categoryId}</td>
                  <td>{category.parentId}</td>
                  <td>{category.categoryName}</td>
                  <td>{category.description}</td>
                  <td>
                    <LinkContainer to={`/admin/category/${category.categoryId}/edit`}>
                      <Button variant="light" className="btn-sm">
                        <i className="fas fa-edit"></i>
                      </Button>
                    </LinkContainer>
                    <Button variant="danger" className="btn-sm" onClick={() => deleteHandler(category.categoryId)}>
                      <i className="fas fa-trash"></i>
                    </Button>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        </>
      )}

      <Row className='m-5 justify-content-md-center'>
        <ReactPaginate
          previousLabel={'Previous'}
          nextLabel={'Next'}
          breakLabel={'...'}
          breakClassName={'break-me'}
          pageCount={pageResponse?.totalPages}
          marginPagesDisplayed={50}
          pageRangeDisplayed={10}
          onPageChange={(e) => handlePageClick(e)}
          containerClassName={'pagination'}
          activeClassName={'page-item active'}
          pageLinkClassName={'page-link'}
          previousClassName={'page-link'}
          nextClassName={'page-link'}
        />
      </Row>
    </>
  );
};

export default CategoryListScreen;
