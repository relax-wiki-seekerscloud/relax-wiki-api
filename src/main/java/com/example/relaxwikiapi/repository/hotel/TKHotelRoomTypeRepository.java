package com.example.relaxwikiapi.repository.hotel;

import com.example.relaxwikiapi.entity.hotel.TKHotel;
import com.example.relaxwikiapi.entity.hotel.TKHotelRoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TKHotelRoomTypeRepository extends JpaRepository<TKHotelRoomType, Long> {

    List<TKHotelRoomType> findAllByTkHotel(TKHotel tkHotel);
}
