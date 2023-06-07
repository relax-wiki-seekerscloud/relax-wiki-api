package com.example.relaxwikiapi.repository.restaurant;

import com.example.relaxwikiapi.entity.restaurant.TKRestaurantFoodCategory;
import com.example.relaxwikiapi.entity.restaurant.TKRestaurantFoodCategoryFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TKRestaurantFoodCategoryFoodRepository extends JpaRepository<TKRestaurantFoodCategoryFood, Long> {

    List<TKRestaurantFoodCategoryFood> findAllByTkRestaurantFoodCategory(TKRestaurantFoodCategory tkRestaurantFoodCategory);
}
