import {
  CATEGORY_LIST_REQUEST,
  CATEGORY_LIST_SUCCESS,
  CATEGORY_LIST_FAIL,
  CATEGORY_DETAILS_REQUEST,
  CATEGORY_DETAILS_SUCCESS,
  CATEGORY_DETAILS_FAIL,
  CATEGORY_DELETE_SUCCESS,
  CATEGORY_DELETE_REQUEST,
  CATEGORY_DELETE_FAIL,
  CATEGORY_CREATE_REQUEST,
  CATEGORY_CREATE_SUCCESS,
  CATEGORY_CREATE_FAIL,
  CATEGORY_UPDATE_REQUEST,
  CATEGORY_UPDATE_SUCCESS,
  CATEGORY_UPDATE_FAIL
} from '../constants/categoryConstants';
import { getErrorMessage } from '../service/CommonUtils';
import {
  getAllCategoriesApi,
  getCategoryDetailApi,
  createCategoryApi,
  deleteCategoryApi, updateCategoryApi
} from '../service/RestApiCalls';

export const listCategoryAction = (pageNumber) => async (dispatch) => {
  try {
    dispatch({ type: CATEGORY_LIST_REQUEST });
    //Get All Products Detail
    const allCategory = await getAllCategoriesApi(pageNumber || 0);
    dispatch({
      type: CATEGORY_LIST_SUCCESS,
      payload: allCategory.page.content,
      pageResponse: allCategory.page
    });
  } catch (error) {
    dispatch({
      type: CATEGORY_LIST_FAIL,
      payload: getErrorMessage(error)
    });
  }
};

export const listCategoryDetailsAction = (categoryId) => async (dispatch) => {
  try {
    dispatch({ type: CATEGORY_DETAILS_REQUEST });
    //Get Category Detail
    const categoryDetail = await getCategoryDetailApi(categoryId);
    dispatch({
      type: CATEGORY_DETAILS_SUCCESS,
      payload: categoryDetail
    });
  } catch (error) {
    dispatch({
      type: CATEGORY_DETAILS_FAIL,
      payload: getErrorMessage(error)
    });
  }
};

export const deleteCategoryAction = (categoryId) => async (dispatch, getState) => {
  try {
    dispatch({
      type: CATEGORY_DELETE_REQUEST
    });

    //Delete Product
    await deleteCategoryApi(categoryId);

    dispatch({
      type: CATEGORY_DELETE_SUCCESS
    });
  } catch (error) {
    const message = error.response && error.response.data.message ? error.response.data.message : error.message;
    if (message === 'Not authorized, token failed') {
      dispatch(logout());
    }
    dispatch({
      type: CATEGORY_DELETE_FAIL,
      payload: message
    });
  }
};

export const createCategoryAction = (categoryReqBody) => async (dispatch) => {
  try {
    dispatch({
      type: CATEGORY_CREATE_REQUEST
    });

    //Create Category
    await createCategoryApi(categoryReqBody);

    dispatch({
      type: CATEGORY_CREATE_SUCCESS
    });
  } catch (error) {
    const message = error.response && error.response.data.message ? error.response.data.message : error.message;
    if (message === 'Not authorized, token failed') {
      dispatch(logout());
    }
    dispatch({
      type: CATEGORY_CREATE_FAIL,
      payload: message
    });
  }
};

export const updateCategoryAction = (categoryReqBody) => async (dispatch) => {
  try {
    dispatch({
      type: CATEGORY_UPDATE_REQUEST
    });

    //Update Category
    await updateCategoryApi(categoryReqBody);

    dispatch({
      type: CATEGORY_UPDATE_SUCCESS
    });
    dispatch(listCategoryDetailsAction(categoryReqBody.categoryId));
  } catch (error) {
    const message = error.response && error.response.data.message ? error.response.data.message : error.message;
    if (message === 'Not authorized, token failed') {
      dispatch(logout());
    }
    dispatch({
      type: CATEGORY_UPDATE_FAIL,
      payload: message
    });
  }
};
