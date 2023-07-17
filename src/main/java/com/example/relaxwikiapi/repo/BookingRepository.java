package com.example.relaxwikiapi.repo;

import com.example.relaxwikiapi.entity.Advertisement;
import com.example.relaxwikiapi.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
