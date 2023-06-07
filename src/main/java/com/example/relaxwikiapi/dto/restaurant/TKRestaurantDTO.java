package com.example.relaxwikiapi.dto.restaurant;

import com.example.relaxwikiapi.constants.AppsConstants;
import com.example.relaxwikiapi.entity.restaurant.TKRestaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKRestaurantDTO {

    private Long restaurantID;

    private String restaurantName;

    private String address;

    private AppsConstants.HotelCondition restaurantCondition;

    private AppsConstants.StarCategory starCategory;

    private AppsConstants.YesNo hasFreeCancellation;

    private List<TKRestaurantImageDTO> restaurantImageDTOList;

    private List<TKRestaurantReviewDTO> restaurantReviewDTOList;

    private List<TKRestaurantFoodCategoryDTO> restaurantFoodCategoryDTOList;

    public TKRestaurantDTO(TKRestaurant restaurant) {
        this.restaurantID = restaurant.getRestaurantID();
        this.restaurantName = restaurant.getRestaurantName();
        this.address = restaurant.getAddress();
        this.restaurantCondition = restaurant.getRestaurantCondition();
        this.starCategory = restaurant.getStarCategory();
        this.hasFreeCancellation = restaurant.getHasFreeCancellation();
    }

    public Long getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Long restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AppsConstants.HotelCondition getRestaurantCondition() {
        return restaurantCondition;
    }

    public void setRestaurantCondition(AppsConstants.HotelCondition restaurantCondition) {
        this.restaurantCondition = restaurantCondition;
    }

    public AppsConstants.StarCategory getStarCategory() {
        return starCategory;
    }

    public void setStarCategory(AppsConstants.StarCategory starCategory) {
        this.starCategory = starCategory;
    }

    public AppsConstants.YesNo getHasFreeCancellation() {
        return hasFreeCancellation;
    }

    public void setHasFreeCancellation(AppsConstants.YesNo hasFreeCancellation) {
        this.hasFreeCancellation = hasFreeCancellation;
    }

    public List<TKRestaurantImageDTO> getRestaurantImageDTOList() {
        if (restaurantImageDTOList == null) {
            restaurantImageDTOList = new ArrayList<>();
        }
        return restaurantImageDTOList;
    }

    public void setRestaurantImageDTOList(List<TKRestaurantImageDTO> restaurantImageDTOList) {
        this.restaurantImageDTOList = restaurantImageDTOList;
    }

    public List<TKRestaurantReviewDTO> getRestaurantReviewDTOList() {
        if (restaurantReviewDTOList == null) {
            restaurantReviewDTOList = new ArrayList<>();
        }
        return restaurantReviewDTOList;
    }

    public void setRestaurantReviewDTOList(List<TKRestaurantReviewDTO> restaurantReviewDTOList) {
        this.restaurantReviewDTOList = restaurantReviewDTOList;
    }

    public List<TKRestaurantFoodCategoryDTO> getRestaurantFoodCategoryDTOList() {
        if (restaurantFoodCategoryDTOList == null) {
            restaurantFoodCategoryDTOList = new ArrayList<>();
        }
        return restaurantFoodCategoryDTOList;
    }

    public void setRestaurantFoodCategoryDTOList(List<TKRestaurantFoodCategoryDTO> restaurantFoodCategoryDTOList) {
        this.restaurantFoodCategoryDTOList = restaurantFoodCategoryDTOList;
    }
}
