package com.cakmak.abc.catalog.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fatma Çakmak, Date : 08-Nov-2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private String productId;
    private String productName;
    private String description;
    private double price;
    private String productCategory;
    private int availableItemCount;
    private Double averageRating;
    private int noOfRatings;
    private String imageId;

}
