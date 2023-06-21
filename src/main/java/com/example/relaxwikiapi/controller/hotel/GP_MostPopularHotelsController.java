package com.example.relaxwikiapi.controller.hotel;

import com.example.relaxwikiapi.entity.hotel.GP_MostPopularHotels;
import com.example.relaxwikiapi.repository.hotel.GP_MostPopularHotelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/mostPopularHotels")
public class GP_MostPopularHotelsController {

    @Autowired
    private GP_MostPopularHotelsRepository gp_mostPopularHotelsRepository;

    @GetMapping("/gelMostPopularHotels")
    public List<GP_MostPopularHotels> gelMostPopularHotels(){
        List<GP_MostPopularHotels> all = this.gp_mostPopularHotelsRepository.findAll();
        return this.getMostPopularHotelsByAllHotels(all);
    }

    public List<GP_MostPopularHotels> getMostPopularHotelsByAllHotels(List<GP_MostPopularHotels> hotels) {
        // Sort the hotels based on the view count in descending order
        List<GP_MostPopularHotels> sortedHotels = hotels.stream()
                .sorted(Comparator.comparingInt(GP_MostPopularHotels::getViewCount).reversed())
                .collect(Collectors.toList());

        // Return the top 5 hotels (or less if the list contains fewer than 5 hotels)
        return sortedHotels.stream()
                .limit(5)
                .collect(Collectors.toList());
    }
}
