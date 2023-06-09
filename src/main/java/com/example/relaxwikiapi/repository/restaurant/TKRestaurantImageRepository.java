package com.example.relaxwikiapi.repository.restaurant;

import com.example.relaxwikiapi.entity.restaurant.TKRestaurant;
import com.example.relaxwikiapi.entity.restaurant.TKRestaurantImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TKRestaurantImageRepository extends JpaRepository<TKRestaurantImage, Long> {

    List<TKRestaurantImage> findAllByTkRestaurant(TKRestaurant tkRestaurant);
}
