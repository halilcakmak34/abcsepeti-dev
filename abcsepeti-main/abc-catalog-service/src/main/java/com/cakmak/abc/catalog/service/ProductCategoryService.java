package com.cakmak.abc.catalog.service;

import com.cakmak.abc.catalog.repository.dao.ProductCategory;
import com.cakmak.abc.catalog.web.CreateProductCategoryRequest;
import com.cakmak.abc.catalog.web.UpdateProductCategoryRequest;
import javax.validation.Valid;
import org.springframework.data.domain.Page;

/**
 * @author: Fatma Çakmak, Date : 2019-09-27
 */
public interface ProductCategoryService {

  String createProductCategory(@Valid CreateProductCategoryRequest createProductCategoryRequest);

  ProductCategory getProductCategory(String productCategoryId);

  void deleteProductCategory(String productCategoryId);

  void updateProductCategory(UpdateProductCategoryRequest updateProductCategoryRequest);

  Page<ProductCategory> getAllProductCategories(String sort, Integer page, Integer size);
}
