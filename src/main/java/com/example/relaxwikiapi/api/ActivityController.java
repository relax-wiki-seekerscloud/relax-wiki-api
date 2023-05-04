package com.example.relaxwikiapi.api;


import com.example.relaxwikiapi.dto.ActivityDTO;
import com.example.relaxwikiapi.entity.Activity;
import com.example.relaxwikiapi.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api/activities")


public class ActivityController {

    @Autowired
    private ActivityService activityService;


    @PostMapping("/addActivity")
    public Activity addActivity(@RequestBody ActivityDTO activityDTO){
        return activityService.addActivity(activityDTO.getActivity());
    }

    @GetMapping("/getActivities")
    public List<Activity> getActivities(){
        return activityService.getActivites();
    }

    @GetMapping("/findByCityPeopleDate")
    List<ActivityDTO> finByCityPeopleDate(
            @RequestParam("city") String city,
            @RequestParam("numOfPeople") int numOfPeople,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return activityService.findByCityPeopleDate(city, numOfPeople, date);
    }


}
