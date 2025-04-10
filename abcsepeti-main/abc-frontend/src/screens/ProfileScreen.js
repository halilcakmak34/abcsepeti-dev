import React, { useEffect, useState } from 'react';
import { Button, Col, Form, Row, Table } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import { LinkContainer } from 'react-router-bootstrap';
import { listMyOrdersAction } from '../actions/orderActions';
import { getUserDetails, updateUserProfile } from '../actions/userActions';
import FullPageLoader from '../components/FullPageLoader';
import Message from '../components/Message';
import { USER_UPDATE_PROFILE_RESET } from '../constants/userConstants';
import { FaEye, FaEyeSlash } from 'react-icons/fa';
import { useTranslation } from 'react-i18next';

const ProfileScreen = ({ history }) => {

  const [showPassword, setShowPassword] = useState(false);
  const [showConfirmPassword, setShowConfirmPassword] = useState(false);
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [message, setMessage] = useState('');

  const { t, i18n } = useTranslation(['translation', 'welcome']);

  const dispatch = useDispatch();

  const userLogin = useSelector((state) => state.userLogin);
  const { userInfo } = userLogin;

  const userDetails = useSelector((state) => state.userDetails);
  const { error: errorUserDetails, loading: loadingUserDetails, user } = userDetails;

  const userUpdateProfile = useSelector((state) => state.userUpdateProfile);
  const { error: errorUpdateUserDetails, loading: loadingUpdateUserDetails, success } = userUpdateProfile;

  const orderListMy = useSelector((state) => state.orderListMy);
  const { error: errorOrderListMy, loading: loadingOrderListMy, orders } = orderListMy;

  useEffect(() => {
    if (!userInfo) {
      history.push('/login');
    } else {
      if (!user || !user.userName) {
        dispatch({ type: USER_UPDATE_PROFILE_RESET });
        dispatch(getUserDetails());
      } else {
        setFirstName(user.firstName);
        setLastName(user.lastName);
        setEmail(user.email);
      }
    }
    dispatch(listMyOrdersAction());
  }, [dispatch, history, userInfo, user]);

  const togglePasswordVisibility = (field) => {
    if (field === 'password') {
      setShowPassword(!showPassword);
    } else if (field === 'confirmPassword') {
      setShowConfirmPassword(!showConfirmPassword);
    }
  };

  const userProfileUpdateHandler = (e) => {
    e.preventDefault();
    setMessage(null);
    if (password !== confirmPassword) {
      setMessage('Passwords do not match');
    } else if (password == null || password == '') {
      setMessage('Passwords cannot be empty');
    } else {
      dispatch(updateUserProfile({ firstName, lastName, email, password }));
    }
  };

  return (
    <Row>
      <Col md={3}>
        <h2>{t('welcome:profileScreen.profile.user')}</h2>
        {message && <Message variant='danger'>{message}</Message>}
        {success && <Message variant='success'>{t('welcome:profileScreen.profile.update')}</Message>}
        {(errorUserDetails || errorUpdateUserDetails) && <Message variant='danger'>{errorUserDetails || errorUpdateUserDetails}</Message>}
        <Form onSubmit={userProfileUpdateHandler}>
          <Form.Group controlId='firstName'>
            <Form.Label>{t('welcome:profileScreen.first.name')}</Form.Label>
            <Form.Control
              type='firstName'
              placeholder={t('welcome:profileScreen.enter.first.name')}
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
            ></Form.Control>
          </Form.Group>

          <Form.Group controlId='lastName'>
            <Form.Label>{t('welcome:profileScreen.last.name')}</Form.Label>
            <Form.Control
              type='lastName'
              placeholder={t('welcome:profileScreen.enter.last.name')}
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
            ></Form.Control>
          </Form.Group>

          <Form.Group controlId='email'>
            <Form.Label>{t('welcome:profileScreen.email.address')}</Form.Label>
            <Form.Control type='email' placeholder={t('welcome:profileScreen.enter.email.address')} value={email} onChange={(e) => setEmail(e.target.value)}></Form.Control>
          </Form.Group>

          <Form.Group controlId='password'>
            <Form.Label>{t('welcome:profileScreen.password')}</Form.Label>
            <div className='input-group'>
              <Form.Control
                  type={showPassword ? 'text' : 'password'}
                  placeholder={t('welcome:profileScreen.enter.password')}
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
              />
              <Button
                  variant='outline-secondary'
                  className='password-icon'
                  onClick={() => togglePasswordVisibility('password')}
              >
            {showPassword ? <FaEyeSlash /> : <FaEye />}
              </Button>
            </div>
          </Form.Group>

          <Form.Group controlId='confirmPassword'>
            <Form.Label>{t('welcome:profileScreen.confirm.password')}</Form.Label>
            <div className='input-group'>
              <Form.Control
                  type={showConfirmPassword ? 'text' : 'password'}
                  placeholder={t('welcome:profileScreen.confirm.password')}
                  value={confirmPassword}
                  onChange={(e) => setConfirmPassword(e.target.value)}
              />
              <Button
                  variant='outline-secondary'
                  className='password-icon'
                  onClick={() => togglePasswordVisibility('confirmPassword')}
              >
            {showConfirmPassword ? <FaEyeSlash /> : <FaEye />}
              </Button>
            </div>
          </Form.Group>

          <Button type='submit' variant='outline-success'>
            {t('welcome:profileScreen.update')}
          </Button>
        </Form>
      </Col>
      <Col md={9}>
        <h2>{t('welcome:profileScreen.myOrders')}</h2>
        {errorOrderListMy ? (
          <Message variant='danger'>{errorOrderListMy}</Message>
        ) : (
          <Table striped bordered hover responsive className='table-sm'>
            <thead>
              <tr>
                <th>{t('welcome:profileScreen.id')}</th>
                <th>{t('welcome:profileScreen.date')}</th>
                <th>{t('welcome:profileScreen.total')}</th>
                <th>{t('welcome:profileScreen.paid')}</th>
                <th>{t('welcome:profileScreen.delivered')}</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              {orders.map((order) => (
                <tr key={order.orderId}>
                  <td>{order.orderId}</td>
                  <td>{order.created_at}</td>
                  <td>{order.totalPrice}</td>
                  <td>{order.paid ? order.paymentDate?.substring(0, 10) : <i className='fas fa-times' style={{ color: 'red' }}></i>}</td>
                  <td>
                    {order.delivered ? order.deliveredDate?.substring(0, 10) : <i className='fas fa-times' style={{ color: 'red' }}></i>}
                  </td>
                  <td>
                    <LinkContainer to={`/order/${order.orderId}`}>
                      <Button className='btn-sm' variant='light'>
                        {t('welcome:profileScreen.details')}
                      </Button>
                    </LinkContainer>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        )}
      </Col>
      {(loadingUserDetails || loadingUpdateUserDetails || loadingOrderListMy) && <FullPageLoader />}
    </Row>
  );
};

export default ProfileScreen;
