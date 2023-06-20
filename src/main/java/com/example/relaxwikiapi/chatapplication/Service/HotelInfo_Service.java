package com.example.relaxwikiapi.chatapplication.Service;

import com.example.relaxwikiapi.chatapplication.Controller.HotelInfoController;
import com.example.relaxwikiapi.chatapplication.Entity.HotelInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hotelInfo")
public class HotelInfo_Service {

    @Autowired
    private HotelInfoController hotelInfoController;

    @GetMapping("/getAllHotels")
    public List<HotelInfo> getAllHotels(){
        return this.hotelInfoController.getAllHotels();
    }

    @GetMapping("/getHotelById/{hotelId}")
    public HotelInfo getHotelById(@PathVariable int hotelId){
        return this.hotelInfoController.getHotelById(hotelId);
    }

    @GetMapping("/getHotelByHotelUserName/{hotelUserName}")
    public HotelInfo getHotelByHotelUserName(@PathVariable String hotelUserName){
        return this.hotelInfoController.getHotelByHotelUserName(hotelUserName);
    }
}
