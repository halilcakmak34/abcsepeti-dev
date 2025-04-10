import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { Form, Button, Row, Col } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import Message from '../components/Message';
import { login } from '../actions/userActions';
import FormContainer from '../components/FormContainer';
import FullPageLoader from '../components/FullPageLoader';
import { useTranslation } from 'react-i18next';

const LoginScreen = (props) => {
  const [userNameOrEmail, setUserNameOrEmail] = useState('');
  const [password, setPassword] = useState('');
  const dispatch = useDispatch();
  const userLogin = useSelector((state) => state.userLogin);
  const { loading, error, userInfo } = userLogin;

  const { t, i18n } = useTranslation(['translation', 'welcome']);

  const redirect = props.location.search ? props.location.search.substring(props.location.search.indexOf('=') + 1) : '/';

  useEffect(() => {
    if (userInfo) {
      props.history.push(redirect);
    }
  }, [props.history, userInfo, redirect]);

  const loginSubmitHandler = (e) => {
    e.preventDefault();
    dispatch(login(userNameOrEmail, password));
  };

  return (
    <div>
      <FormContainer>
        <h1>{t('welcome:loginScreen.sign.in')}</h1>
        {error && <Message variant='danger'>{JSON.stringify(error)}</Message>}
        <Form onSubmit={loginSubmitHandler}>
          <Form.Group controlId='userNameOrEmail'>
            <Form.Label>{t('welcome:loginScreen.email.address')}</Form.Label>
            <Form.Control
              placeholder={t('welcome:loginScreen.username.or.email')}
              value={userNameOrEmail}
              onChange={(e) => setUserNameOrEmail(e.target.value)}
            ></Form.Control>
          </Form.Group>

          <Form.Group controlId='password'>
            <Form.Label>{t('welcome:loginScreen.password')}</Form.Label>
            <Form.Control
              placeholder={t('welcome:loginScreen.password')}
              type='password'
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            ></Form.Control>
          </Form.Group>

          <Button type='submit' variant='primary'>
            {t('welcome:loginScreen.sign.in')}
          </Button>
        </Form>

        <Row className='py-3'>
          <Col>
            {t('welcome:loginScreen.new.costumer')}? <Link to={redirect ? `/register?redirect=${redirect}` : '/register'}>{t('welcome:loginScreen.register')}</Link>
          </Col>
        </Row>
      </FormContainer>
      {loading && <FullPageLoader></FullPageLoader>}
    </div>
  );
};

export default LoginScreen;
