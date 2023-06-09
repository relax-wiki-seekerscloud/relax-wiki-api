package com.example.relaxwikiapi.repository.hotel;

import com.example.relaxwikiapi.entity.hotel.TKHotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TKHotelBookingRepository extends JpaRepository<TKHotelBooking, Long> {
}
