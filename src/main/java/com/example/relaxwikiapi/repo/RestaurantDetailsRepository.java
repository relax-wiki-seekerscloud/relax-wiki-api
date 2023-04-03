package com.example.relaxwikiapi.repo;

import com.example.relaxwikiapi.entity.RestaurantDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDetailsRepository extends JpaRepository<RestaurantDetails, Long> {
}
