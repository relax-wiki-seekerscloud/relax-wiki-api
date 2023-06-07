package com.example.relaxwikiapi.entity.restaurant;

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
@Table(name = "tk_restaurant_food_category")
public class TKRestaurantFoodCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_food_category_id")
    private Long restaurantFoodCategoryID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private TKRestaurant tkRestaurant;

    @Column(name = "main_description", nullable = false)
    private String mainDescription;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "tkRestaurantFoodCategory")
    private Set<TKRestaurantFoodCategoryFood> tkRestaurantFoodCategoryFoods;

    public Set<TKRestaurantFoodCategoryFood> getTkRestaurantFoodCategoryFoods() {
        if (tkRestaurantFoodCategoryFoods == null) {
            tkRestaurantFoodCategoryFoods = new HashSet<>();
        }
        return tkRestaurantFoodCategoryFoods;
    }

    public void setTkRestaurantFoodCategoryFoods(Set<TKRestaurantFoodCategoryFood> tkRestaurantFoodCategoryFoods) {
        this.tkRestaurantFoodCategoryFoods = tkRestaurantFoodCategoryFoods;
    }
}
