package com.example.relaxwikiapi.service;

import com.example.relaxwikiapi.entity.Review;
import com.example.relaxwikiapi.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceIMPL implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> showAllReviews() {
        return reviewRepository.findAll();
    }
}

