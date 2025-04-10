import Paginate from '../components/Paginate';
import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import Product from '../components/Product';
import Message from '../components/Message';
import { Button, Col, Form, Row } from 'react-bootstrap';
import { listProductsAction } from '../actions/productActions';
import FullPageLoader from '../components/FullPageLoader';
import ReactPaginate from 'react-paginate';
import { getAllCategories, getCategories } from '../service/RestApiCalls';
import { MegaMenu } from 'primereact/megamenu';
import { InputText } from 'primereact/inputtext';

import { Trans, useTranslation } from 'react-i18next';

const HomeScreen = () => {
  const { t, i18n } = useTranslation(['translation', 'welcome']);

  const changeLanguage = code => {
    i18n.changeLanguage(code);
  };
  const dispatch = useDispatch();
  const productList = useSelector((state) => state.productList);
  const [categories, setCategories] = useState([]);

  const { loading, error, products, pageResponse } = productList;

  useEffect(() => {

    dispatch(listProductsAction(0,""));
  }, [dispatch]);

  const handlePageClick = (data) => {
    let selected = data.selected;
    dispatch(listProductsAction(selected,searchKey));
  };

  const handleSearchClick = () => {
    dispatch(listProductsAction(0,searchKey));
  };


  const items = [
    {
      label: 'Cars', icon: 'pi pi-fw pi-video',
      items: [
        [
          {
            label: 'car 1',
            items: [{ label: 'car 1.1' }, { label: 'car 1.2' }]
          },
          {
            label: 'car 2',
            items: [{ label: 'car 2.1' }, { label: 'car 2.2' }]
          }
        ],
        [
          {
            label: 'car 3',
            items: [{ label: 'car 3.1' }, { label: 'car 3.2' }]
          },
          {
            label: 'car 4',
            items: [{ label: 'car 4.1' }, { label: 'car 4.2' }]
          }
        ]
      ]
    },
    {
      label: 'Giyim', icon: 'pi pi-fw pi-users',
      items: [
        [
          {
            label: 'Erkek Giyim',
            items: [{ label: 'pantolon' }, { label: 'Gömlek' }]
          },
          {
            label: 'Bayan Giyim',
            items: [{ label: 'elbise' }, { label: 'etek' }]
          },
        ],
        [
          {
            label: 'User 3',
            items: [{ label: 'User 3.1' }, { label: 'User 3.2' }]
          },
          {
            label: 'User 4',
            items: [{ label: 'User 4.1' }, { label: 'User 4.2' }]
          }
        ],
        [
          {
            label: 'User 5',
            items: [{ label: 'User 5.1' }, { label: 'User 5.2' }]
          },
          {
            label: 'User 6',
            items: [{ label: 'User 6.1' }, { label: 'User 6.2' }]
          }
        ]
      ]
    },
    {
      label: 'Events', icon: 'pi pi-fw pi-calendar',
      items: [
        [
          {
            label: 'Event 1',
            items: [{ label: 'Event 1.1' }, { label: 'Event 1.2' }]
          },
          {
            label: 'Event 2',
            items: [{ label: 'Event 2.1' }, { label: 'Event 2.2' }]
          }
        ],
        [
          {
            label: 'Event 3',
            items: [{ label: 'Event 3.1' }, { label: 'Event 3.2' }]
          },
          {
            label: 'Event 4',
            items: [{ label: 'Event 4.1' }, { label: 'Event 4.2' }]
          }
        ]
      ]
    },
    {
      label: 'Settings', icon: 'pi pi-fw pi-cog',
      items: [
        [
          {
            label: 'Setting 1',
            items: [{ label: 'Setting 1.1' }, { label: 'Setting 1.2' }]
          },
          {
            label: 'Setting 2',
            items: [{ label: 'Setting 2.1' }, { label: 'Setting 2.2' }]
          },
          {
            label: 'Setting 3',
            items: [{ label: 'Setting 3.1' }, { label: 'Setting 3.2' }]
          }
        ],
        [
          {
            label: 'Technology 4',
            items: [{ label: 'Setting 4.1' }, { label: 'Setting 4.2' }]
          }
        ]
      ]
    }
  ]


    const [searchKey, setSearchKey] = useState('');



    return (
      <>

        <Row>
          <Col>
            <Form.Control
              type="text"
              placeholder={t('welcome:home.search')}
              value={searchKey}
              onChange={(e) => setSearchKey(e.target.value)}

            ></Form.Control>
          </Col>
          <Col>
            <Button variant="success" className="search-tag-holder-result" onClick={() => handleSearchClick()}>
              <i className="fas fa-trash"></i>
            </Button>
          </Col>
        </Row>

        <p>
          <h2>{t('welcome:home.categories')}</h2>
        </p>


        <MegaMenu model={categories} />


        <h1>{t('welcome:home.title.latest.products')}</h1>
        {error ? (
          <Message variant="danger"></Message>
        ) : (
          <>
            <Row>
              {products.map((product) => (
                <Col key={product.productId} sm={12} md={6} lg={4} xl={3}>
                  <Product key={product.productId} product={product}></Product>
                </Col>
              ))}
            </Row>
            {/* pageResponse?.pageable?.pageNumber */}
            <Row className="m-5 justify-content-md-center">
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
        )}
        {loading && <FullPageLoader></FullPageLoader>}
      </>
    );
};


export default HomeScreen;
