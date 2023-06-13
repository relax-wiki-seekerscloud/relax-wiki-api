package com.example.relaxwikiapi.service.restaurant;

import com.example.relaxwikiapi.dto.restaurant.TKRestaurantDTO;
import com.example.relaxwikiapi.dto.restaurant.TKRestaurantSearchRQ;
import com.example.relaxwikiapi.exception.AppsException;

import java.util.List;

public interface TKRestaurantService {
    List<TKRestaurantDTO> searchRestaurants(TKRestaurantSearchRQ searchRQ) throws AppsException;

    TKRestaurantDTO findRestaurantByID(Long restaurantID) throws AppsException;
}
