package com.cakmak.abc.catalog.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Fatma Cakmak, Date : 08-Nov-2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesNameResponse {

    private String label;
    private List<CategoriesNameResponse> items;

    public CategoriesNameResponse(String label) {
        this.label=label;

    }
}
