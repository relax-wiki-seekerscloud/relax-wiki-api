package com.example.relaxwikiapi.entity.restaurant;

import com.example.relaxwikiapi.constants.AppsConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tk_restaurant")
public class TKRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long restaurantID;

    @Column(name = "restaurant_name", nullable = false)
    private String restaurantName;

    @Column(name = "address", nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "restaurant_condition", nullable = false, length = 50)
    private AppsConstants.HotelCondition restaurantCondition;

    @Enumerated(EnumType.STRING)
    @Column(name = "star_category", nullable = false, length = 50)
    private AppsConstants.StarCategory starCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "has_free_cancellation", nullable = false, length = 2)
    private AppsConstants.YesNo hasFreeCancellation;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "tkRestaurant")
    private Set<TKRestaurantImage> tkRestaurantImages;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "tkRestaurant")
    private Set<TKRestaurantReview> tkRestaurantReviews;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "tkRestaurant")
    private Set<TKRestaurantFoodCategory> tkRestaurantFoodCategories;

    public Set<TKRestaurantImage> getTkRestaurantImages() {
        if (tkRestaurantImages == null) {
            tkRestaurantImages = new HashSet<>();
        }
        return tkRestaurantImages;
    }

    public void setTkRestaurantImages(Set<TKRestaurantImage> tkRestaurantImages) {
        this.tkRestaurantImages = tkRestaurantImages;
    }

    public Set<TKRestaurantReview> getTkRestaurantReviews() {
        if (tkRestaurantReviews == null) {
            tkRestaurantReviews = new HashSet<>();
        }
        return tkRestaurantReviews;
    }

    public void setTkRestaurantReviews(Set<TKRestaurantReview> tkRestaurantReviews) {
        this.tkRestaurantReviews = tkRestaurantReviews;
    }

    public Set<TKRestaurantFoodCategory> getTkRestaurantFoodCategories() {
        if (tkRestaurantFoodCategories == null) {
            tkRestaurantFoodCategories = new HashSet<>();
        }
        return tkRestaurantFoodCategories;
    }

    public void setTkRestaurantFoodCategories(Set<TKRestaurantFoodCategory> tkRestaurantFoodCategories) {
        this.tkRestaurantFoodCategories = tkRestaurantFoodCategories;
    }
}
