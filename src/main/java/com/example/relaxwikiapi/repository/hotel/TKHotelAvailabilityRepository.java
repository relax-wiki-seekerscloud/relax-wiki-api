package com.example.relaxwikiapi.repository.hotel;

import com.example.relaxwikiapi.entity.hotel.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TKHotelAvailabilityRepository extends JpaRepository<TKHotelAvailability, Long> {

    List<TKHotelAvailability> findAllByTkHotel(TKHotel tkHotel);

    List<TKHotelAvailability> findAllByTkHotelAndDate(TKHotel hotel, LocalDate date);
}
