package com.example.relaxwikiapi.repository.restaurant;

import com.example.relaxwikiapi.entity.restaurant.TKRestaurant;
import com.example.relaxwikiapi.entity.restaurant.TKRestaurantFoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TKRestaurantFoodCategoryRepository extends JpaRepository<TKRestaurantFoodCategory, Long> {

    List<TKRestaurantFoodCategory> findAllByTkRestaurant(TKRestaurant tkRestaurant);
}
