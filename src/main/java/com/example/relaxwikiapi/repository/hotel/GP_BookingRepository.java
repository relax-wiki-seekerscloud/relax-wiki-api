package com.example.relaxwikiapi.repository.hotel;

import com.example.relaxwikiapi.entity.hotel.GP_Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GP_BookingRepository extends JpaRepository<GP_Booking,Integer> {



}
