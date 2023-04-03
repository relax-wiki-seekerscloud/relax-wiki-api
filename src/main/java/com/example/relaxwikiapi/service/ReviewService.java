package com.example.relaxwikiapi.service;

import com.example.relaxwikiapi.entity.Review;

import java.util.List;

public interface ReviewService {

    Review addReview(Review review);

    List<Review> showAllReviews();
}