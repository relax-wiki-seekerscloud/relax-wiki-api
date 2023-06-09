package com.example.relaxwikiapi.dto.restaurant;

import com.example.relaxwikiapi.entity.restaurant.TKRestaurantImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKRestaurantImageDTO {

    private Long restaurantImageID;

    private Long restaurantID;

    private Integer displayOrder;

    private String imageURL;

    public TKRestaurantImageDTO(TKRestaurantImage restaurantImage) {
        this.restaurantImageID = restaurantImage.getRestaurantImageID();
        this.restaurantID = restaurantImage.getTkRestaurant().getRestaurantID();
        this.displayOrder = restaurantImage.getDisplayOrder();
        this.imageURL = restaurantImage.getImageURL();
    }
}
