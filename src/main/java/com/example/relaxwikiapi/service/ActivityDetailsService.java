package com.example.relaxwikiapi.service;

import com.example.relaxwikiapi.dto.NewActivityDTO;
import com.example.relaxwikiapi.entity.ActivityDetails;

import java.util.List;

public interface ActivityDetailsService {
    ActivityDetails addActivityDetails(ActivityDetails activityDetails);
    String addNewActivity(NewActivityDTO newActivityDTO);
    List<ActivityDetails> findAllActivityDetails();
    ActivityDetails getActivityDetailsById(Long id);


    ActivityDetails updateName(Long id, String name);
    ActivityDetails updateAddress(Long id, String address);
    ActivityDetails updateTourDuration(Long id, String tourDuration);
    ActivityDetails updatePhoneNo(Long id, String phoneNo);
    ActivityDetails updateEmail(Long id, String email);
    ActivityDetails updatePassword(Long id, String password);
    ActivityDetails updatePhoto(Long id, byte[] photo);


    ActivityDetails updateLanguage(Long id, List<String> languages);
    ActivityDetails updateServices(Long id, List<String> services);
    ActivityDetails updateMealsProvided(Long id, List<String> mealsProvided);
    ActivityDetails updateTransportationMethods(Long id, List<String> transportationMethods);
    ActivityDetails updateLowestRateForOnePerson(Long id, int lowestRateForOnePerson);
    ActivityDetails updatePaymentMethods(Long id, List<String> paymentMethods);
}
