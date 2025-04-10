import React, { useState, useEffect } from 'react';
import { PayPalButton } from 'react-paypal-button-v2';
import { Link } from 'react-router-dom';
import { Row, Col, ListGroup, Image, Card, Button } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import Message from '../components/Message';
import Loader from '../components/Loader';
import { getOrderDetailsAction } from '../actions/orderActions';
import OrderItem from '../components/OrderItem';
import { useTranslation } from 'react-i18next';
// import { getOrderDetails, payOrder, deliverOrder } from '../actions/orderActions';
// import { ORDER_PAY_RESET, ORDER_DELIVER_RESET } from '../constants/orderConstants';

const OrderScreen = ({ match, history }) => {
  const orderId = match.params.id;
  const [successPay, setSuccessPay] = useState(false);
  const [successDeliver, setSuccessDeliver] = useState(false);
  const [loadingDeliver, setLoadingDeliver] = useState(false);
  const [loadingPay, setLoadingPay] = useState(false);
  const [sdkReady, setSdkReady] = useState(false);

  const { t, i18n } = useTranslation(['translation', 'welcome']);

  const dispatch = useDispatch();

  // const [order, setOrder] = useState(null);
  //   const orderDetails = useSelector((state) => state.orderDetails);
  //   const { order, loading, error } = orderDetails;

  //   const orderPay = useSelector((state) => state.orderPay);
  //   const { loading: loadingPay, success: successPay } = orderPay;

  //   const orderDeliver = useSelector((state) => state.orderDeliver);
  //   const { loading: loadingDeliver, success: successDeliver } = orderDeliver;

  const userLogin = useSelector((state) => state.userLogin);
  const { userInfo } = userLogin;

  const orderDetail = useSelector((state) => state.orderDetails);
  const { order, loading, error } = orderDetail;

  useEffect(() => {
    if (!userInfo) {
      history.push('/login');
    }
    dispatch(getOrderDetailsAction(orderId));
  }, [dispatch, orderId]);

  const deliverHandler = () => {
    // dispatch(deliverOrder(order));
  };

  const getRandomNumber = () => {
    return Math.floor(Math.random() * 10);
  };

  return (
    <>
      {loading === true ? (
        <Loader />
      ) : error ? (
        <Message variant='danger'>{error}</Message>
      ) : (
        <>
          <h1>{t('welcome:orderScreen.order')} - {order.orderId}</h1>
          <hr></hr>
          <Row>
            <Col md={8}>
              <ListGroup variant='flush'>
                <ListGroup.Item>
                  <h2>{t('welcome:orderScreen.shipping')}</h2>
                  <p>
                    <strong>{t('welcome:orderScreen.name')}: </strong> {userInfo.userName}
                  </p>
                  <p>
                    <strong>{t('welcome:orderScreen.email')}: </strong> <a href={`mailto:${userInfo.email}`}>{userInfo.email}</a>
                  </p>
                  <p>
                    <strong>{t('welcome:orderScreen.address')}:</strong>
                    {order.shippingAddress.addressLine1}, {order.shippingAddress.city} {order.shippingAddress.postalCode},{' '}
                    {order.shippingAddress.country}
                  </p>
                  {order.delivered ? (
                    <Message variant='success'>Delivered on {order.deliveredAt}</Message>
                  ) : (
                    <Message variant='danger'>Not Delivered</Message>
                  )}
                </ListGroup.Item>

                <ListGroup.Item>
                  <h2>{t('welcome:orderScreen.payment.method')}</h2>
                  <p>
                    <strong>{t('welcome:orderScreen.method')}: </strong>
                    {order.card.cardBrand.toUpperCase()} - **** **** **** {order.card.last4Digits}
                  </p>
                  {order.paid ? (
                    <Message variant='success'>Paid on {order.paymentDate}</Message>
                  ) : (
                    <Message variant='danger'>Not Paid</Message>
                  )}

                  <p>
                    <strong>{t('welcome:orderScreen.payment.receipt')}  : </strong>
                    <a href={order.paymentReceiptUrl} target='_blank'>
                      {order.paymentReceiptUrl}
                    </a>
                  </p>
                </ListGroup.Item>

                <ListGroup.Item>
                  <h2>{t('welcome:orderScreen.order.item')}</h2>
                  {order.orderItems.length === 0 ? (
                    <Message>{t('welcome:orderScreen.order.is.empty')}</Message>
                  ) : (
                    <ListGroup variant='flush'>
                      {order.orderItems.map((item, index) => (
                        <OrderItem item={item}></OrderItem>
                      ))}
                    </ListGroup>
                  )}
                </ListGroup.Item>
              </ListGroup>
            </Col>
            <Col md={4}>
              <Card>
                <ListGroup variant='flush'>
                  <ListGroup.Item>
                    <h2>{t('welcome:orderScreen.order.summary')}</h2>
                  </ListGroup.Item>
                  <ListGroup.Item>
                    <Row>
                      <Col>{t('welcome:orderScreen.items')}</Col>
                      <Col>${order.itemsTotalPrice}</Col>
                    </Row>
                  </ListGroup.Item>
                  <ListGroup.Item>
                    <Row>
                      <Col>{t('welcome:orderScreen.shipping')}</Col>
                      <Col>${order.shippingPrice}</Col>
                    </Row>
                  </ListGroup.Item>
                  <ListGroup.Item>
                    <Row>
                      <Col>{t('welcome:orderScreen.tax')}</Col>
                      <Col>${order.taxPrice}</Col>
                    </Row>
                  </ListGroup.Item>
                  <ListGroup.Item>
                    <Row>
                      <Col>{t('welcome:orderScreen.total')}</Col>
                      <Col>${order.totalPrice}</Col>
                    </Row>
                  </ListGroup.Item>
                  {loadingDeliver && <Loader />}
                  {userInfo && userInfo.isAdmin && order.isPaid && !order.isDelivered && (
                    <ListGroup.Item>
                      <Button type='button' className='btn btn-block' onClick={deliverHandler}>
                        {t('welcome:orderScreen.mark.as.delivered')}
                      </Button>
                    </ListGroup.Item>
                  )}
                </ListGroup>
              </Card>
            </Col>
          </Row>
        </>
      )}
    </>
  );
};

export default OrderScreen;
