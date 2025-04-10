import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { Form, Button, Row, Col } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import Message from '../components/Message';
import { register } from '../actions/userActions';
import FormContainer from '../components/FormContainer';
import FullPageLoader from '../components/FullPageLoader';
import { USER_REGISTER_RESET } from '../constants/userConstants';
import Deneme from '../components/Deneme';
import { useTranslation } from 'react-i18next';

const RegisterScreen = (props) => {
  const [userName, setUserName] = useState('');
  const [firstName, setFirstName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setconfirmPassword] = useState('');
  const [message, setMessage] = useState(null);

  const dispatch = useDispatch();
  const userRegister = useSelector((state) => state.userRegister);
  let { loading, error, userInfo } = userRegister;

  const redirect = props.location.search ? props.location.search.substring(props.location.search.indexOf('=') + 1) : '/';

  const { t, i18n } = useTranslation(['translation', 'welcome']);

  useEffect(() => {
    if (userInfo) {
      props.history.push(redirect);
    }
  }, [props.history, userInfo, redirect]);

  const registerHandler = (e) => {
    setMessage(null);
    e.preventDefault();
    //Register
    if (password !== confirmPassword) {
      setMessage('Passwords do not match');
      dispatch({ type: USER_REGISTER_RESET });
    } else {
      dispatch(register(userName, firstName, email, password));
    }
  };

  return (
    <div>
      <FormContainer>
        <h1>{t('welcome:registerScreen.sign.in')}</h1>
        {message && <Message variant='danger'>{message}</Message>}
        {error && <Message variant='danger'>{JSON.stringify(error)}</Message>}
        <Form onSubmit={registerHandler}>
          <Form.Group controlId="userName">
            <Form.Label>{t('welcome:registerScreen.username')}</Form.Label>
            <Form.Control required placeholder={t('welcome:registerScreen.username')} value={userName}
                          onChange={(e) => setUserName(e.target.value)}></Form.Control>
          </Form.Group>

          <Form.Group controlId="firstName">
            <Form.Label>{t('welcome:registerScreen.first.name')}</Form.Label>
            <Form.Control required placeholder={t('welcome:registerScreen.first.name')} value={firstName}
                          onChange={(e) => setFirstName(e.target.value)}></Form.Control>
          </Form.Group>

          <Form.Group controlId="email">
            <Form.Label>{t('welcome:registerScreen.email')}</Form.Label>
            <Form.Control required type="email" placeholder={t('welcome:registerScreen.email')} value={email}
                          onChange={(e) => setEmail(e.target.value)}></Form.Control>
          </Form.Group>

          <Form.Group controlId="password">
            <Form.Label>{t('welcome:registerScreen.password')}</Form.Label>
            <Form.Control
              required
              placeholder={t('welcome:registerScreen.password')}
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            ></Form.Control>
          </Form.Group>

          <Form.Group controlId="password">
            <Form.Label>{t('welcome:registerScreen.confirm.password')}</Form.Label>
            <Form.Control
              required
              placeholder={t('welcome:registerScreen.confirm.password')}
              type="password"
              value={confirmPassword}
              onChange={(e) => setconfirmPassword(e.target.value)}
            ></Form.Control>
          </Form.Group>

          <Button  type="submit" variant={'primary'}>
            {t('welcome:registerScreen.register')}
          </Button>
          <Deneme></Deneme>
        </Form>

        <Row className="py-3">
          <Col>
            {t('welcome:registerScreen.haveAAccount')}? <Link to={redirect ? `/login?redirect=${redirect}` : '/login'}>{t('welcome:registerScreen.login')}</Link>
          </Col>
        </Row>
      </FormContainer>
      {loading && <FullPageLoader></FullPageLoader>}
    </div>
  );
};

export default RegisterScreen;
