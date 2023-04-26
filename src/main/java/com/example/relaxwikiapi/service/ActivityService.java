package com.example.relaxwikiapi.service;

import com.example.relaxwikiapi.dto.ActivityDTO;
import com.example.relaxwikiapi.entity.Activity;

import java.time.LocalDate;
import java.util.List;

public interface ActivityService {

    Activity addActivity(Activity activity);

    List<Activity> getActivites();

    List<ActivityDTO> findByCityPeopleDate(String city, int numOfPeople, LocalDate date);




}
