package com.cakmak.abc.catalog.repository;

import com.cakmak.abc.catalog.repository.dao.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Fatma Cakmak,
 * Date : 2019-06-06
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findByProductNameIsStartingWith(String searchKey, Pageable pageable);


}
