package com.example.relaxwikiapi.repository.hotel;

import com.example.relaxwikiapi.entity.hotel.TKHotel;
import com.example.relaxwikiapi.entity.hotel.TKHotelReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TKHotelReviewRepository extends JpaRepository<TKHotelReview, Long> {

    List<TKHotelReview> findByTkHotel(TKHotel tkHotel);
}
