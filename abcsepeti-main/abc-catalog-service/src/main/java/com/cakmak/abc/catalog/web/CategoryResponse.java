package com.cakmak.abc.catalog.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fatma Cakmak, Date : 08-Nov-2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {

    private String categoryId;
    private String parentId;
    private String categoryName;
    private String description;
}
