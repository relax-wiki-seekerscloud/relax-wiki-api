package com.example.relaxwikiapi.repository.hotel;

import com.example.relaxwikiapi.entity.hotel.TKHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TKHotelRepository extends JpaRepository<TKHotel, Long> {
}
