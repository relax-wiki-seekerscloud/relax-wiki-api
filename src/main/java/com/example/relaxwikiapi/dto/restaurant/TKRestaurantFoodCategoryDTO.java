package com.example.relaxwikiapi.dto.restaurant;

import com.example.relaxwikiapi.entity.restaurant.TKRestaurantFoodCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKRestaurantFoodCategoryDTO {

    private Long restaurantFoodCategoryID;

    private Long restaurantID;

    private String mainDescription;

    private List<TKRestaurantFoodCategoryFoodDTO> foodDTOList;

    public TKRestaurantFoodCategoryDTO(TKRestaurantFoodCategory restaurantFoodCategory) {
        this.restaurantFoodCategoryID = restaurantFoodCategory.getRestaurantFoodCategoryID();
        this.restaurantID = restaurantFoodCategory.getTkRestaurant().getRestaurantID();
        this.mainDescription = restaurantFoodCategory.getMainDescription();
    }

    public List<TKRestaurantFoodCategoryFoodDTO> getFoodDTOList() {
        if (foodDTOList == null) {
            foodDTOList = new ArrayList<>();
        }
        return foodDTOList;
    }

    public void setFoodDTOList(List<TKRestaurantFoodCategoryFoodDTO> foodDTOList) {
        this.foodDTOList = foodDTOList;
    }
}
