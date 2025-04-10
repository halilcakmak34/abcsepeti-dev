import React from 'react';
import { Container, Nav, Navbar, NavDropdown } from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import { isAdmin } from '../service/CommonUtils';
import { logout } from '../actions/userActions';
import { Trans, useTranslation } from 'react-i18next';
const Header = (props) => {
  const { t, i18n } = useTranslation(['translation', 'welcome']);
  const userLogin = useSelector((state) => state.userLogin);
  const { userInfo } = userLogin;

  const dispatch = useDispatch();

  const logoutHandler = () => {
    dispatch(logout());
  };

  const changeLanguage = code => {
    i18n.changeLanguage(code);
  };


  return (
    <header>
      <Navbar
        style={{
          background: 'linear-gradient(142deg, rgba(131,58,180,1) 0%, rgba(253,29,29,1) 68%, rgba(252,176,69,1) 100%)',
          border: '0',
          color: '#00000'
        }}
        className='navbar navbar-expand-lg navbar-dark'
        collapseOnSelect
      >
        <Container>
          <LinkContainer to='/'>
            <Navbar.Brand className='bookstore-brand'>Abcsepeti</Navbar.Brand>
          </LinkContainer>
          <Navbar.Toggle aria-controls='basic-navbar-nav' />
          <Navbar.Collapse id='basic-navbar-nav'>
            <Nav className='navbar-nav ml-auto'>
              <LinkContainer to='/cart'>
                <Nav.Link>
                  <i className='p-1 fas fa-shopping-cart'></i>Cart
                </Nav.Link>
              </LinkContainer>

              <LinkContainer to='/'>
                <Nav.Link>{t('welcome:header.menu')}</Nav.Link>
              </LinkContainer>

              <NavDropdown title={t('welcome:language')} id='adminmenu'>
                <NavDropdown.Item onClick={() => changeLanguage('tr')}>{t('translation:tr')}</NavDropdown.Item>
                <NavDropdown.Item onClick={() => changeLanguage('en')}>{t('translation:en')}</NavDropdown.Item>
                <NavDropdown.Item onClick={() => changeLanguage('de')}>{t('translation:de')}</NavDropdown.Item>
              </NavDropdown>



              {userInfo ? (
                <NavDropdown title={userInfo.userName} id="username">
                  <LinkContainer to='/userProfile'>
                    <NavDropdown.Item>{t('welcome:header.profile')}</NavDropdown.Item>
                  </LinkContainer>
                  <NavDropdown.Item onClick={logoutHandler}>{t('welcome:header.logout')}</NavDropdown.Item>
                </NavDropdown>
              ) : (
                <LinkContainer to='/login'>
                  <Nav.Link href='/login'>
                    <i className='p-1 fas fa-user'></i>{t('welcome:header.sign.in')}
                  </Nav.Link>
                </LinkContainer>
              )}
              {userInfo && isAdmin() && (
                <NavDropdown title='Admin' id='adminmenu'>
                  <LinkContainer to='/admin/userlist'>
                    <NavDropdown.Item>{t('welcome:header.users')}</NavDropdown.Item>
                  </LinkContainer>
                  <LinkContainer to='/admin/productlist'>
                    <NavDropdown.Item>{t('welcome:header.products')}</NavDropdown.Item>
                  </LinkContainer>
                  <LinkContainer to='/admin/orderlist'>
                    <NavDropdown.Item>{t('welcome:header.orders')}</NavDropdown.Item>
                  </LinkContainer>
                  <LinkContainer to='/admin/category/categoryList'>
                    <NavDropdown.Item>{t('welcome:header.category')}</NavDropdown.Item>
                  </LinkContainer>
                </NavDropdown>


              )}


            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </header>
  );
};

export default Header;
