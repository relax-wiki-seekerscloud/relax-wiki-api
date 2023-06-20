package com.example.relaxwikiapi.chatapplication.Controller;

import com.example.relaxwikiapi.chatapplication.Entity.HotelInfo;
import com.example.relaxwikiapi.chatapplication.Exception.ResourceNotFoundException;
import com.example.relaxwikiapi.chatapplication.Repository.HotelInfo_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HotelInfoController {

    @Autowired
    private HotelInfo_Repository hotelInfo_repository;

    public HotelInfo getHotelById(int hotelId){
        return this.hotelInfo_repository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Does not exists a hotel with id "+ hotelId));
    }

    public List<HotelInfo> getAllHotels() {
        return this.hotelInfo_repository.findAll();
    }

    public HotelInfo getHotelByHotelUserName(String hotelUserName) {
        return this.hotelInfo_repository.findByHotelName(hotelUserName);
    }
}
