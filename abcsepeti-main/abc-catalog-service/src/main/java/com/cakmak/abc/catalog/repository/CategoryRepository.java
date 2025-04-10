package com.cakmak.abc.catalog.repository;

import com.cakmak.abc.catalog.repository.dao.MyCategory;
import org.apache.commons.codec.language.bm.Languages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Fatma Cakmak,
 * Date : 2019-06-06
 */
@Repository
public interface CategoryRepository extends JpaRepository<MyCategory, String> {

    Page<MyCategory> getAllByParentIdIsNotNull(Pageable pageable);

    @Query(value = "select c from MyCategory c where c.categoryName= :categoryName")
    List<MyCategory> getAllByCategoryName(String categoryName);
}
