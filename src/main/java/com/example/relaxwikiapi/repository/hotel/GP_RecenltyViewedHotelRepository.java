package com.example.relaxwikiapi.repository.hotel;

import com.example.relaxwikiapi.entity.hotel.GP_RecenltyViewedHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GP_RecenltyViewedHotelRepository extends JpaRepository<GP_RecenltyViewedHotel,Integer> {
    @Query("SELECT h FROM GP_RecenltyViewedHotel h ORDER BY h.loginId DESC")
    List<GP_RecenltyViewedHotel> findAllInDescendingOrder();
}
