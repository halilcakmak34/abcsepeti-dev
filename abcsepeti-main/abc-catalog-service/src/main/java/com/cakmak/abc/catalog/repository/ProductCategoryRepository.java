package com.cakmak.abc.catalog.repository;

import com.cakmak.abc.catalog.repository.dao.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Halil Cakmak,
 * Date : 2019-06-06
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {
}
