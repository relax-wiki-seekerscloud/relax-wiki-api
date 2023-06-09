package com.example.relaxwikiapi.repository.hotel;

import com.example.relaxwikiapi.entity.hotel.TKHotel;
import com.example.relaxwikiapi.entity.hotel.TKHotelImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TKHotelImageRepository extends JpaRepository<TKHotelImage, Long> {

    List<TKHotelImage> findAllByTkHotel(TKHotel tkHotel);
}
