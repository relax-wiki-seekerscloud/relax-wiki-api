package com.example.relaxwikiapi.repository.hotel;

import com.example.relaxwikiapi.entity.hotel.TKHotelRoomType;
import com.example.relaxwikiapi.entity.hotel.TKHotelRoomTypeFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TKHotelRoomTypeFacilityRepository extends JpaRepository<TKHotelRoomTypeFacility, Long> {

    List<TKHotelRoomTypeFacility> findAllByTkHotelRoomType(TKHotelRoomType tkHotelRoomType);
}
