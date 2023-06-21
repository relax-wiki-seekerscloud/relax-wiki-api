package com.example.relaxwikiapi.controller.hotel;

import com.example.relaxwikiapi.entity.GP_Offers;
import com.example.relaxwikiapi.repository.hotel.GP_OffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/offer")
public class GPOfferController {

    @Autowired
    private GP_OffersRepository gp_offersRepository;

    @GetMapping("/getOffers")
    public List<GP_Offers> getLastTwoOffers() {
        List<GP_Offers> allGPOffers = gp_offersRepository.findAll();
        int size = allGPOffers.size();
        int startIndex = size - 2 >= 0 ? size - 2 : 0;
        int endIndex = size;

        return allGPOffers.subList(startIndex, endIndex);
    }
}
