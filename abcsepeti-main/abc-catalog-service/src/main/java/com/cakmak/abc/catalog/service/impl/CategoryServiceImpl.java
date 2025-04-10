package com.cakmak.abc.catalog.service.impl;

import com.cakmak.abc.catalog.repository.CategoryRepository;
import com.cakmak.abc.catalog.repository.ProductCategoryRepository;
import com.cakmak.abc.catalog.repository.ProductRepository;
import com.cakmak.abc.catalog.repository.ReviewRepository;
import com.cakmak.abc.catalog.repository.dao.MyCategory;
import com.cakmak.abc.catalog.repository.dao.Product;
import com.cakmak.abc.catalog.repository.dao.ProductCategory;
import com.cakmak.abc.catalog.repository.dao.Review;
import com.cakmak.abc.catalog.service.CategoryService;
import com.cakmak.abc.catalog.service.ProductService;
import com.cakmak.abc.catalog.service.ReviewService;
import com.cakmak.abc.catalog.web.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: Fatma Cakmak,
 * Date : 2019-06-06
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ObjectMapper objectMapper;
    private MyCategory save;

    @Override
    public String createCategory(@Valid CreateCategoryRequest createCategoryRequest) {

        MyCategory category = MyCategory.builder()
                .categoryName(createCategoryRequest.getCategoryName())
                .description(createCategoryRequest.getDescription())
                .parentId(createCategoryRequest.getParentId())
                .build();


        MyCategory savedCategory = categoryRepository.save(category);
        return savedCategory.getCategoryId();
    }

    @Override
    public CategoryResponse getCategory(String categoryId) {
        Optional<MyCategory> categoryOptional =
                categoryRepository.findById(categoryId);

        MyCategory category = categoryOptional.orElseThrow(() -> new RuntimeException("Product Id doesn't exist!"));
        CategoryResponse categoryResponse = objectMapper.convertValue(category, CategoryResponse.class);
        return categoryResponse;
    }

    @Override
    public List<CategoriesNameResponse> getAll() {
        List<MyCategory> allctgry = categoryRepository.findAll();
        List<CategoriesNameResponse> categories = new ArrayList<>();
        for (MyCategory myCategory: allctgry) {

                CategoriesNameResponse ctgry = new CategoriesNameResponse();
                ctgry.setLabel(myCategory.getCategoryName());

                List<CategoriesNameResponse> items = myCategory.getSubCategories().stream().filter(i -> i.getParentId()!=null && i.getParentId().equals(myCategory.getCategoryId())).map(j -> new CategoriesNameResponse(j.getCategoryName())).collect(Collectors.toList());
                ctgry.setItems(items);
                ctgry.setLabel(ctgry.getLabel());


                categories.add(ctgry);
        }
        return categories;
    }


    @Override
    public void deleteCategory(String categoryId) {

        categoryRepository.deleteById(categoryId);

    }

    @Override
    public void updateCategory(UpdateCategoryRequest updateCategoryRequest) {

        Optional<MyCategory> categoryOptional =
                categoryRepository.findById(updateCategoryRequest.getCategoryId());

        //check weather product exists
        final MyCategory categoryExisting = categoryOptional.orElseThrow(() -> new RuntimeException("Product Id doesn't exist!"));

        categoryExisting.setCategoryId(updateCategoryRequest.getCategoryId());

        if (updateCategoryRequest.getCategoryName() != null) {
            categoryExisting.setCategoryName(updateCategoryRequest.getCategoryName());
        }

        if (updateCategoryRequest.getDescription() != null) {
            categoryExisting.setDescription(updateCategoryRequest.getDescription());
        }

        if (Objects.nonNull(updateCategoryRequest.getParentId())) {
            categoryExisting.setParentId(updateCategoryRequest.getParentId());
        }

        categoryExisting.setCreatedAt(categoryExisting.getCreatedAt());

        categoryRepository.save(categoryExisting);
    }

    @Override
    public Page<MyCategory> findAllCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
    
    @Override
    public Page<CategoryResponse> getAllCategory(Pageable pageable) {

        Page<MyCategory> categories = categoryRepository.getAllByParentIdIsNotNull(pageable);
        Page<CategoryResponse> allCategoryResponse = categories.map(MyCategory::fromEntity);

        return allCategoryResponse;
    }

    @Override
    public List<MyCategory> getCategories() {
        return categoryRepository.findAll();
    }


}
