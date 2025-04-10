package com.cakmak.abc.catalog.service;

import com.cakmak.abc.catalog.repository.dao.MyCategory;
import com.cakmak.abc.catalog.repository.dao.Product;
import com.cakmak.abc.catalog.web.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: Fatma Çakmak, Date : 2019-09-27
 */
public interface CategoryService {

  String createCategory(@Valid CreateCategoryRequest createCategoryRequest);

  CategoryResponse getCategory(String categoryId);
  List<CategoriesNameResponse> getAll();

  void deleteCategory(String categoryId);

  void updateCategory(UpdateCategoryRequest updateCategoryRequest);

  Page<MyCategory> findAllCategory(Pageable pageable);

  Page<CategoryResponse> getAllCategory(Pageable pageable);

  List<MyCategory> getCategories();
}
