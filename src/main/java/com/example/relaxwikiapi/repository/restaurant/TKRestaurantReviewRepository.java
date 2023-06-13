package com.example.relaxwikiapi.repository.restaurant;

import com.example.relaxwikiapi.entity.restaurant.TKRestaurant;
import com.example.relaxwikiapi.entity.restaurant.TKRestaurantReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TKRestaurantReviewRepository extends JpaRepository<TKRestaurantReview, Long> {

    List<TKRestaurantReview> findAllByTkRestaurant(TKRestaurant tkRestaurant);
}
