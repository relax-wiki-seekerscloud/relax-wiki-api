package com.example.relaxwikiapi.entity.restaurant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tk_restaurant_review")
public class TKRestaurantReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_review_id")
    private Long restaurantReviewID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private TKRestaurant tkRestaurant;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "reviewer_name", nullable = false)
    private String reviewerName;
}
