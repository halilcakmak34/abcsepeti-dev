package com.cakmak.abc.catalog.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author: Fatma Cakmak,
 * Date : 2019-06-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {

    @NotNull(message = "categoryId should not be null!")
    @NotEmpty(message = "categoryId should not be empty!")
    private String categoryId;

    @NotNull(message = "categoryName should not be null!")
    @NotEmpty(message = "categoryName should not be empty!")
    private String categoryName;

    private String description;
    @NotNull(message = "parentId should not be null!")
    @NotEmpty(message = "parentId should not be empty!")
    private String parentId;

}
