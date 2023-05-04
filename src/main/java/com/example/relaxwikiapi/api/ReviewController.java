package com.example.relaxwikiapi.api;

import com.example.relaxwikiapi.entity.Review;
import com.example.relaxwikiapi.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    @PostMapping("/addReview")
    public Review addUser(@RequestBody Review review){

        return reviewService.addReview(review);
    }


    @GetMapping("/showAllReviews")
    public List<Review> showAllReviews(){

        return reviewService.showAllReviews();
    }
}
