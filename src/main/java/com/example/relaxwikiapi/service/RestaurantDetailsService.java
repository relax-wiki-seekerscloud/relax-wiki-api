package com.example.relaxwikiapi.service;

import com.example.relaxwikiapi.dto.NewHotelDTO;
import com.example.relaxwikiapi.dto.NewRestaurantDTO;
import com.example.relaxwikiapi.entity.RestaurantDetails;

import java.util.List;

public interface RestaurantDetailsService {
    RestaurantDetails addRestaurantDetails(RestaurantDetails restaurantDetails);

    String addNewRestaurant(NewRestaurantDTO newRestaurantDTO);
    List<RestaurantDetails> findAllRestaurantDetails();
    RestaurantDetails getRestaurantDetailsById(Long id);


    RestaurantDetails updateName(Long id, String name);
    RestaurantDetails updateAddress(Long id, String address);
    RestaurantDetails updateOpeningHours(Long id, String openingHours);
    RestaurantDetails updatePhoneNo(Long id, String phoneNo);
    RestaurantDetails updateEmail(Long id, String email);
    RestaurantDetails updatePassword(Long id, String password);
    RestaurantDetails updatePhoto(Long id, byte[] photo);


    RestaurantDetails updateLanguage(Long id, List<String> languages);
    RestaurantDetails updateMealsServed(Long id, List<String> mealsServed);
    RestaurantDetails updatePaymentMethods(Long id, List<String> paymentMethods);
    RestaurantDetails updateParking(Long id, List<String> parking);
    RestaurantDetails updateAtmosphere(Long id, List<String> atmosphere);
    RestaurantDetails updateAdditional(Long id, List<String> additional);
}
