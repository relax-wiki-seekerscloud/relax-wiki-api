package com.example.relaxwikiapi.repo;

import com.example.relaxwikiapi.entity.HotelDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelDetailsRepository extends JpaRepository<HotelDetails, Long> {
}
