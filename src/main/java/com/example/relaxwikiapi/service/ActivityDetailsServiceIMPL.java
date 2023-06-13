package com.example.relaxwikiapi.service;

import com.example.relaxwikiapi.dto.AddOnDTO;
import com.example.relaxwikiapi.dto.NewActivityDTO;
import com.example.relaxwikiapi.entity.ActivityDetails;
import com.example.relaxwikiapi.entity.AddOn;
import com.example.relaxwikiapi.entity.User;
import com.example.relaxwikiapi.repo.ActivityDetailsRepository;
import com.example.relaxwikiapi.repo.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityDetailsServiceIMPL implements ActivityDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityDetailsRepository activityDetailsRepository;

    @Override
    public ActivityDetails addActivityDetails(ActivityDetails activityDetails) {
        return activityDetailsRepository.save(activityDetails);
    }

    @Override
    public List<ActivityDetails> findAllActivityDetails() {
        return activityDetailsRepository.findAll();
    }

    @Override
    public ActivityDetails getActivityDetailsById(Long id) {
        return activityDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public ActivityDetails updateName(Long id, String name) {
        ActivityDetails activityDetails = activityDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        activityDetails.setName(name);
        return activityDetailsRepository.save(activityDetails);
    }

    @Override
    public ActivityDetails updateAddress(Long id, String address) {
        ActivityDetails activityDetails = activityDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        activityDetails.setAddress(address);
        return activityDetailsRepository.save(activityDetails);
    }

    @Override
    public ActivityDetails updateTourDuration(Long id, String tourDuration) {
        ActivityDetails activityDetails = activityDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        activityDetails.setTourDuration(tourDuration);
        return activityDetailsRepository.save(activityDetails);
    }

    @Override
    public ActivityDetails updatePhoneNo(Long id, String phoneNo) {
        ActivityDetails activityDetails = activityDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        activityDetails.setPhoneNo(phoneNo);
        return activityDetailsRepository.save(activityDetails);
    }

    @Override
    public ActivityDetails updateEmail(Long id, String email) {
        ActivityDetails activityDetails = activityDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        activityDetails.setEmail(email);
        return activityDetailsRepository.save(activityDetails);
    }

    @Override
    public ActivityDetails updatePassword(Long id, String password) {
        ActivityDetails activityDetails = activityDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        activityDetails.setPassword(password);
        return activityDetailsRepository.save(activityDetails);
    }

    @Override
    public ActivityDetails updatePhoto(Long id, byte[] photo) {
        ActivityDetails activityDetails = activityDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        activityDetails.setPhoto(photo);
        return activityDetailsRepository.save(activityDetails);
    }

    @Override
    public ActivityDetails updateLanguage(Long id, List<String> languages) {
        ActivityDetails activityDetails = activityDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        activityDetails.setLanguages(languages);
        return activityDetailsRepository.save(activityDetails);
    }

    @Override
    public ActivityDetails updateServices(Long id, List<String> services) {
        ActivityDetails activityDetails = activityDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        activityDetails.setServices(services);
        return activityDetailsRepository.save(activityDetails);
    }

    @Override
    public ActivityDetails updateMealsProvided(Long id, List<String> mealsProvided) {
        ActivityDetails activityDetails = activityDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        activityDetails.setMealsProvided(mealsProvided);
        return activityDetailsRepository.save(activityDetails);
    }

    @Override
    public ActivityDetails updateTransportationMethods(Long id, List<String> transportationMethods) {
        ActivityDetails activityDetails = activityDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        activityDetails.setTransportationMethods(transportationMethods);
        return activityDetailsRepository.save(activityDetails);
    }

    @Override
    public ActivityDetails updateLowestRateForOnePerson(Long id, int lowestRateForOnePerson) {
        ActivityDetails activityDetails = activityDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        activityDetails.setLowestRateForOnePerson(lowestRateForOnePerson);
        return activityDetailsRepository.save(activityDetails);
    }

    @Override
    public ActivityDetails updatePaymentMethods(Long id, List<String> paymentMethods) {
        ActivityDetails activityDetails = activityDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity details not found"));
        activityDetails.setPaymentMethods(paymentMethods);
        return activityDetailsRepository.save(activityDetails);
    }

    @Override
    public String addNewActivity(NewActivityDTO newActivityDTO) {
        ActivityDetails activity = new ActivityDetails();
        activity.setName(newActivityDTO.getActivityCenterName());
        activity.setActivityCenterDesc(newActivityDTO.getActivityCenterDesc());
        activity.setContactPersonName(newActivityDTO.getContactPersonName());
        activity.setAddress(newActivityDTO.getPostalCode()+","+newActivityDTO.getStreetAddress()+","+newActivityDTO.getAddressLine2()+","+newActivityDTO.getCity()+","+newActivityDTO.getCountry());
        activity.setTransportationMethods(newActivityDTO.getTransportationMethods());
        activity.setEntertainmentCategory(newActivityDTO.getEntertainmentCategory());
        activity.setOpenTimeFrom(newActivityDTO.getOpenTimeFrom());
        activity.setOpenTimeTo(newActivityDTO.getOpenTimeTo());
        activity.setLowestRateForOnePerson(newActivityDTO.getLowestRateForOnePerson());
        activity.setLanguages(newActivityDTO.getLanguages());
        activity.setBookingCancelPeriod(newActivityDTO.getBookingCancelPeriod());
        activity.setBookingCancelCharge(newActivityDTO.getBookingCancelCharge());
        activity.setPaymentMethods(newActivityDTO.getPaymentMethods());
        activity.setMealsProvided(newActivityDTO.getMealsProvided());
        activity.setPhotoUrls(newActivityDTO.getPhotoUrls());
        User user = userRepository.findByEmail("taneesha@gmail.com");
        activity.setUser(user);
//        if (newActivityDTO.getAddOns()!=null){
//            for (AddOnDTO addOnDTO:newActivityDTO.getAddOns()){
//            AddOn addOn=new AddOn();
//            addOn.setCategory(addOnDTO.getCategory());
//            addOn.setName(addOnDTO.getName());
//            activity.addAddOn(addOn);
//        }
//    }
        if (newActivityDTO.getActivities()!=null){
            for (String activities:newActivityDTO.getActivities()){
                AddOn addOn=new AddOn();
                addOn.setCategory("Activity");
                addOn.setName(activities);
                activity.addAddOn(addOn);
            }
        }

        if (newActivityDTO.getFacilities()!=null){
            for (String facilities:newActivityDTO.getFacilities()){
                AddOn addOn=new AddOn();
                addOn.setCategory("Facility");
                addOn.setName(facilities);
                activity.addAddOn(addOn);
            }
        }

        if (newActivityDTO.getPackages()!=null){
            for (String packages:newActivityDTO.getPackages()){
                AddOn addOn=new AddOn();
                addOn.setCategory("Package");
                addOn.setName(packages);
                activity.addAddOn(addOn);
            }
        }

        try {
            activityDetailsRepository.save(activity);
        } catch (Exception e) {
            System.out.println(e);
            return "Error";
        }
        return "Success";
    }
}
