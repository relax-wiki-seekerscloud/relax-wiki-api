package com.example.relaxwikiapi.controller.hotel;


import com.example.relaxwikiapi.entity.hotel.GP_RecenltyViewedHotel;
import com.example.relaxwikiapi.repository.hotel.GP_RecenltyViewedHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/gphotel")
public class GPHotelController {

    @Autowired
    private GP_RecenltyViewedHotelRepository gpRecenltyViewedHotelRepository;

    @GetMapping("/erecentltyViewed/{userID}")
    public List<GP_RecenltyViewedHotel> getRecentlyViewedHotels(@PathVariable String userID) {

        List<GP_RecenltyViewedHotel> allHotels = gpRecenltyViewedHotelRepository.findAll();
        List<GP_RecenltyViewedHotel> recentHotels = new ArrayList<>();

        for(GP_RecenltyViewedHotel gpRecenltyViewedHotel:allHotels){
            if(Objects.equals(gpRecenltyViewedHotel.getGpUser().getUserId(), userID)){
                recentHotels.add(gpRecenltyViewedHotel);
            }
        }
        List<GP_RecenltyViewedHotel> lastFourRecentHotels = new ArrayList<>();

        int numToRetrieve = Math.min(4, recentHotels.size());  // Retrieve up to 4 items or the available number of items if less

        if (numToRetrieve > 0) {
            lastFourRecentHotels = recentHotels.subList(recentHotels.size() - numToRetrieve, recentHotels.size());
        }

        return lastFourRecentHotels;

    }
}
