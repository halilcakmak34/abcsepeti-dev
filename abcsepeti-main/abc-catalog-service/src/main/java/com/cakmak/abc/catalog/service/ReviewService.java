package com.cakmak.abc.catalog.service;

import com.cakmak.abc.catalog.repository.dao.Review;
import com.cakmak.abc.catalog.web.CreateOrUpdateReviewRequest;

import java.util.List;

/**
 * @author Halil Cakmak, Date : 08-Nov-2020
 */
public interface ReviewService {

    void createOrUpdateReview(CreateOrUpdateReviewRequest createOrUpdateReviewRequest);

    List<Review> getReviewsForProduct(String productId);

}
