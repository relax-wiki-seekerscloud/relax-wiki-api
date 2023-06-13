package com.example.relaxwikiapi.api;

import com.example.relaxwikiapi.dto.ActivityDetailsDTO;
import com.example.relaxwikiapi.dto.NewActivityDTO;
import com.example.relaxwikiapi.entity.ActivityDetails;
import com.example.relaxwikiapi.service.ActivityDetailsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/activityDetails")

public class ActivityDetailsController {
    @Autowired
    private ActivityDetailsService activityDetailsService;

    @PostMapping("/addActivityDetails")
    public ActivityDetails addActivityDetails(@RequestBody ActivityDetails activityDetails){
        return activityDetailsService.addActivityDetails(activityDetails);
    }

    @GetMapping("/findAllActivityDetails")
    public List<ActivityDetails> getAllActivityDetails() {
        return activityDetailsService.findAllActivityDetails();
    }

    @GetMapping("/findActivityDetailsById/{id}")
    public ActivityDetails getActivityDetailsById(@PathVariable Long id){
        return activityDetailsService.getActivityDetailsById(id);
    }

    @PatchMapping("/updateActivityDetailsName/{id}")
    public ActivityDetails updateName(@PathVariable Long id, @RequestParam String name) {
        return activityDetailsService.updateName(id, name);
    }

    @PatchMapping("/updateActivityDetailsAddress/{id}")
    public ActivityDetails updateAddress(@PathVariable Long id, @RequestParam String address) {
        return activityDetailsService.updateAddress(id, address);
    }

    @PatchMapping("/updateAct ivityDetailsTourDuration/{id}")
    public ActivityDetails updateTourDuration(@PathVariable Long id, @RequestParam String tourDuration) {
        return activityDetailsService.updateTourDuration(id, tourDuration);
    }

    @PatchMapping("/updateActivityDetailsPhoneNo/{id}")
    public ActivityDetails updatePhoneNo(@PathVariable Long id, @RequestParam String phoneNo) {
        return activityDetailsService.updatePhoneNo(id, phoneNo);
    }

    @PatchMapping("/updateActivityDetailsEmail/{id}")
    public ActivityDetails updateEmail(@PathVariable Long id, @RequestParam String email) {
        return activityDetailsService.updateEmail(id, email);
    }

    @PatchMapping("/updateActivityDetailsPassword/{id}")
    public ActivityDetails updatePassword(@PathVariable Long id, @RequestParam String password) {
        return activityDetailsService.updatePassword(id, password);
    }

    @PatchMapping("/updateActivityDetailsPhoto/{id}")
    public ActivityDetails updatePhoto(@PathVariable Long id, @RequestParam byte[] photo) {
        return activityDetailsService.updatePhoto(id, photo);
    }

    @PatchMapping("/updateHotelDetailsLanguages/{id}")
    public ActivityDetails updateLanguages(@PathVariable Long id, @RequestBody ActivityDetailsDTO activityDetailsDTO) {
        List<String> languages = activityDetailsDTO.getLanguages();
        return activityDetailsService.updateLanguage(id, languages);
    }

    @PatchMapping("/updateHotelDetailsServices/{id}")
    public ActivityDetails updateServices(@PathVariable Long id, @RequestBody ActivityDetailsDTO activityDetailsDTO) {
        List<String> services = activityDetailsDTO.getServices();
        return activityDetailsService.updateServices(id, services);
    }

    @PatchMapping("/updateHotelDetailsMealsProvided/{id}")
    public ActivityDetails updateMealsProvided(@PathVariable Long id, @RequestBody ActivityDetailsDTO activityDetailsDTO) {
        List<String> mealsProvided = activityDetailsDTO.getMealsProvided();
        return activityDetailsService.updateMealsProvided(id, mealsProvided);
    }

    @PatchMapping("/updateHotelDetailsTransportationMethods/{id}")
    public ActivityDetails updateTransportationMethods(@PathVariable Long id, @RequestBody ActivityDetailsDTO activityDetailsDTO) {
        List<String> transportationMethods = activityDetailsDTO.getTransportationMethods();
        return activityDetailsService.updateTransportationMethods(id, transportationMethods);
    }

    @PatchMapping("/updateActivityDetailsLowestRateForOnePerson/{id}")
    public ActivityDetails updateLowestRateForOnePerson(@PathVariable Long id, @RequestParam int lowestRateForOnePerson) {
        return activityDetailsService.updateLowestRateForOnePerson(id, lowestRateForOnePerson);
    }

    @PatchMapping("/updateHotelDetailsPaymentMethods/{id}")
    public ActivityDetails updatePaymentMethods(@PathVariable Long id, @RequestBody ActivityDetailsDTO activityDetailsDTO) {
        List<String> paymentMethods = activityDetailsDTO.getPaymentMethods();
        return activityDetailsService.updatePaymentMethods(id, paymentMethods);
    }

    @PostMapping("/add-new-activity")
    public ResponseEntity<?> newActivity(@Valid @RequestBody NewActivityDTO newActivityDTO){
        System.out.println("hi activity center");
        this.activityDetailsService.addNewActivity(newActivityDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
