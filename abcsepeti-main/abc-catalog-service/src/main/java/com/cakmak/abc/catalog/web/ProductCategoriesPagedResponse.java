package com.cakmak.abc.catalog.web;

import com.cakmak.abc.catalog.repository.dao.ProductCategory;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Halil Cakmak,
 * Date : 2019-08-29
 */
@Data
public class ProductCategoriesPagedResponse {
    
    Page<ProductCategory> page;
    Map<String, String> _links = new HashMap<>();
    
}
