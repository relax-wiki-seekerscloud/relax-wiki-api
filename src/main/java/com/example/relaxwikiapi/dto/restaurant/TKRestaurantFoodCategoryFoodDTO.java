package com.example.relaxwikiapi.dto.restaurant;

import com.example.relaxwikiapi.entity.restaurant.TKRestaurantFoodCategory;
import com.example.relaxwikiapi.entity.restaurant.TKRestaurantFoodCategoryFood;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKRestaurantFoodCategoryFoodDTO {

    private Long restaurantFoodCategoryFoodID;

    private Long restaurantFoodCategoryID;

    private String description;

    public TKRestaurantFoodCategoryFoodDTO(TKRestaurantFoodCategoryFood restaurantFoodCategoryFood) {
        this.restaurantFoodCategoryFoodID = restaurantFoodCategoryFood.getRestaurantFoodCategoryFoodID();
        this.restaurantFoodCategoryID = restaurantFoodCategoryFood.getTkRestaurantFoodCategory().getRestaurantFoodCategoryID();
        this.description = restaurantFoodCategoryFood.getDescription();
    }
}
