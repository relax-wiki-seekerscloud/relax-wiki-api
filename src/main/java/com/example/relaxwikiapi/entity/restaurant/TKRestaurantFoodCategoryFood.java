package com.example.relaxwikiapi.entity.restaurant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tk_restaurant_food_category_food")
public class TKRestaurantFoodCategoryFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_food_category_food_id")
    private Long restaurantFoodCategoryFoodID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_food_category_id")
    private TKRestaurantFoodCategory tkRestaurantFoodCategory;

    @Column(name = "description", nullable = false)
    private String description;
}
