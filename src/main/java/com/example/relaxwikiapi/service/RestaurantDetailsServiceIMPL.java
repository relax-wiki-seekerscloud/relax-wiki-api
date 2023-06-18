package com.example.relaxwikiapi.service;

import com.example.relaxwikiapi.dto.AddOnDTO;
import com.example.relaxwikiapi.dto.NewRestaurantDTO;
import com.example.relaxwikiapi.entity.AddOn;
import com.example.relaxwikiapi.entity.RestaurantDetails;
import com.example.relaxwikiapi.entity.User;
import com.example.relaxwikiapi.repo.RestaurantDetailsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.relaxwikiapi.repo.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantDetailsServiceIMPL implements RestaurantDetailsService {

    @Autowired
    private RestaurantDetailsRepository restaurantDetailsRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public RestaurantDetails addRestaurantDetails(RestaurantDetails restaurantDetails) {
        return restaurantDetailsRepository.save(restaurantDetails);
    }

    @Override
    public List<RestaurantDetails> findAllRestaurantDetails() {
        return restaurantDetailsRepository.findAll();
    }

    @Override
    public RestaurantDetails getRestaurantDetailsById(Long id) {
        return restaurantDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public RestaurantDetails updateName(Long id, String name) {
        RestaurantDetails restaurantDetails = restaurantDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant details not found"));
        restaurantDetails.setName(name);
        return restaurantDetailsRepository.save(restaurantDetails);
    }

    @Override
    public RestaurantDetails updateAddress(Long id, String address) {
        RestaurantDetails restaurantDetails = restaurantDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant details not found"));
        restaurantDetails.setAddress(address);
        return restaurantDetailsRepository.save(restaurantDetails);
    }

    @Override
    public RestaurantDetails updateOpeningHours(Long id, String openingHours) {
        RestaurantDetails restaurantDetails = restaurantDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant details not found"));
        restaurantDetails.setOpeningHours(openingHours);
        return restaurantDetailsRepository.save(restaurantDetails);
    }

    @Override
    public RestaurantDetails updatePhoneNo(Long id, String phoneNo) {
        RestaurantDetails restaurantDetails = restaurantDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant details not found"));
        restaurantDetails.setPhoneNo(phoneNo);
        return restaurantDetailsRepository.save(restaurantDetails);
    }

    @Override
    public RestaurantDetails updateEmail(Long id, String email) {
        RestaurantDetails restaurantDetails = restaurantDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant details not found"));
        restaurantDetails.setEmail(email);
        return restaurantDetailsRepository.save(restaurantDetails);
    }

    @Override
    public RestaurantDetails updatePassword(Long id, String password) {
        RestaurantDetails restaurantDetails = restaurantDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant details not found"));
        restaurantDetails.setPassword(password);
        return restaurantDetailsRepository.save(restaurantDetails);
    }

    @Override
    public RestaurantDetails updatePhoto(Long id, byte[] photo) {
        RestaurantDetails restaurantDetails = restaurantDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant details not found"));
        restaurantDetails.setPhoto(photo);
        return restaurantDetailsRepository.save(restaurantDetails);
    }

    @Override
    public RestaurantDetails updateLanguage(Long id, List<String> languages) {
        RestaurantDetails restaurantDetails = restaurantDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        restaurantDetails.setLanguages(languages);
        return restaurantDetailsRepository.save(restaurantDetails);
    }

    @Override
    public RestaurantDetails updateMealsServed(Long id, List<String> mealsServed) {
        RestaurantDetails restaurantDetails = restaurantDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        restaurantDetails.setMealsServed(mealsServed);
        return restaurantDetailsRepository.save(restaurantDetails);
    }

    @Override
    public RestaurantDetails updatePaymentMethods(Long id, List<String> paymentMethods) {
        RestaurantDetails restaurantDetails = restaurantDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        restaurantDetails.setPaymentMethods(paymentMethods);
        return restaurantDetailsRepository.save(restaurantDetails);
    }

    @Override
    public RestaurantDetails updateParking(Long id, List<String> parking) {
        RestaurantDetails restaurantDetails = restaurantDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        restaurantDetails.setParking(parking);
        return restaurantDetailsRepository.save(restaurantDetails);
    }

    @Override
    public RestaurantDetails updateAtmosphere(Long id, List<String> atmosphere) {
        RestaurantDetails restaurantDetails = restaurantDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        restaurantDetails.setAtmosphere(atmosphere);
        return restaurantDetailsRepository.save(restaurantDetails);
    }

    @Override
    public RestaurantDetails updateAdditional(Long id, List<String> additional) {
        RestaurantDetails restaurantDetails = restaurantDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        restaurantDetails.setAdditional(additional);
        return restaurantDetailsRepository.save(restaurantDetails);
    }

    @Override
    public String addNewRestaurant(NewRestaurantDTO newRestaurantDTO,User user) {

        RestaurantDetails restaurant = new RestaurantDetails();
        restaurant.setName(newRestaurantDTO.getRestaurantName());
        restaurant.setContactPersonName(newRestaurantDTO.getContactPersonName());
        restaurant.setAddress(newRestaurantDTO.getPostalCode() + "," + newRestaurantDTO.getStreetAddress() + "," + newRestaurantDTO.getAddressLine2() + "," + newRestaurantDTO.getCity() + "," + newRestaurantDTO.getCountry());
        restaurant.setLanguages(newRestaurantDTO.getLanguages());
        restaurant.setPhotoUrls(newRestaurantDTO.getPhotoUrls());
        restaurant.setContactNumbers(newRestaurantDTO.getContactNumbers());
        restaurant.setRestaurantDesc(newRestaurantDTO.getRestaurantDesc());
        restaurant.setPaymentMethods(newRestaurantDTO.getPaymentMethods());
        restaurant.setMealsServed(newRestaurantDTO.getMealsServed());
        restaurant.setRestaurantCategory(newRestaurantDTO.getRestaurantCategory());
        restaurant.setOfferedCuisine(newRestaurantDTO.getOfferedCuisine());
        restaurant.setOpenTimeForm(newRestaurantDTO.getOpenTimeFrom());
        restaurant.setOpenTimeTo(newRestaurantDTO.getOpenTimeTo());

        restaurant.setUser(user);

//        if (newRestaurantDTO.getAddOns() != null) {
//            for (AddOnDTO addOnDTO : newRestaurantDTO.getAddOns()) {
//                AddOn addOn = new AddOn();
//                addOn.setType(addOnDTO.getType());
//                addOn.setCategory(addOnDTO.getCategory());
//                addOn.setName(addOnDTO.getName());
//                restaurant.addAddOn(addOn);
//            }
//        }

        if (newRestaurantDTO.getParking()!=null){
            for (String parking:newRestaurantDTO.getParking()){
                AddOn addOn=new AddOn();
                addOn.setCategory("Parking");
                addOn.setName(parking);
                restaurant.addAddOn(addOn);
            }
        }

        if (newRestaurantDTO.getAtmosphere()!=null){
            for (String atmosphere:newRestaurantDTO.getAtmosphere()){
                AddOn addOn=new AddOn();
                addOn.setCategory("Atmosphere");
                addOn.setName(atmosphere);
                restaurant.addAddOn(addOn);
            }
        }

        if (newRestaurantDTO.getAdditional()!=null){
            for (String additional:newRestaurantDTO.getAdditional()){
                AddOn addOn=new AddOn();
                addOn.setCategory("Additional");
                addOn.setName(additional);
                restaurant.addAddOn(addOn);
            }
        }

        try {
            restaurantDetailsRepository.save(restaurant);
        } catch (Exception e) {
            System.out.println(e);
            return "Error";
        }
        return "Success";
    }

}
