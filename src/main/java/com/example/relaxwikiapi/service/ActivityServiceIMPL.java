package com.example.relaxwikiapi.service;

import com.example.relaxwikiapi.dto.ActivityDTO;
import com.example.relaxwikiapi.entity.Activity;
import com.example.relaxwikiapi.repo.ActivityCenterLocationRepository;
import com.example.relaxwikiapi.repo.ActivityCenterRepository;
import com.example.relaxwikiapi.repo.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service

public class ActivityServiceIMPL implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityCenterRepository activityCenterRepository;

    @Autowired
    private ActivityCenterLocationRepository activityCenterLocationRepository;

    @Override
    public Activity addActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> getActivites() {
        return activityRepository.findAll();
    }

    @Override
    public List<ActivityDTO> findByCityPeopleDate(String city, int numOfPeople, LocalDate date) {
        List<Activity> activities = activityRepository.findByCityPeopleDate(city, numOfPeople, date);
        List<ActivityDTO> activityDTOs = new ArrayList<>();
        for (Activity activity : activities) {
            ActivityDTO activityDTO = new ActivityDTO(activity, numOfPeople);
            activityDTOs.add(activityDTO);
        }
        return activityDTOs;
    }





}


