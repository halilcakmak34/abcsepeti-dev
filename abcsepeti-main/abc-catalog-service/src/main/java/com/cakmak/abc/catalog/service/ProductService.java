package com.cakmak.abc.catalog.service;

import com.cakmak.abc.catalog.repository.ProductRepository;
import com.cakmak.abc.catalog.repository.dao.Product;
import com.cakmak.abc.catalog.web.CreateProductRequest;
import com.cakmak.abc.catalog.web.ProductResponse;
import com.cakmak.abc.catalog.web.UpdateProductRequest;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.Array;

/**
 * @author: Fatma Çakmak, Date : 2019-09-27
 */
public interface ProductService {

  String createProduct(@Valid CreateProductRequest createProductRequest);

  ProductResponse getProduct(String productId);

  void deleteProduct(String productId);

  void updateProduct(UpdateProductRequest updateProductRequest);

  Page<Product> findAllProducts(Pageable pageable);



  Page<ProductResponse> getAllProducts(String sort, Integer page, Integer size, String searchKey);
}
