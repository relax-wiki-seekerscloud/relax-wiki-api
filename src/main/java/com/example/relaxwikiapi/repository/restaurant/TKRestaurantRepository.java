package com.example.relaxwikiapi.repository.restaurant;

import com.example.relaxwikiapi.entity.restaurant.TKRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TKRestaurantRepository extends JpaRepository<TKRestaurant, Long> {
}
