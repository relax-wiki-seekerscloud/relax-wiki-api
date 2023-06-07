package com.example.relaxwikiapi.dto.restaurant;

import com.example.relaxwikiapi.entity.restaurant.TKRestaurantReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKRestaurantReviewDTO {

    private Long restaurantReviewID;

    private Long restaurantID;

    private String description;

    private String reviewerName;

    public TKRestaurantReviewDTO(TKRestaurantReview restaurantReview) {
        this.restaurantReviewID = restaurantReview.getRestaurantReviewID();
        this.restaurantID = restaurantReview.getTkRestaurant().getRestaurantID();
        this.description = restaurantReview.getDescription();
        this.reviewerName = restaurantReview.getReviewerName();
    }
}
