package com.example.relaxwikiapi.chatapplication.Repository;


import com.example.relaxwikiapi.chatapplication.Entity.HotelInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelInfo_Repository extends JpaRepository<HotelInfo,Integer> {
    HotelInfo findByHotelName(String hotelName);
}
