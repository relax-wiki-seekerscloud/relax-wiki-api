package com.example.relaxwikiapi.repository.entertainment;

import com.example.relaxwikiapi.entity.entertainment.TKEntertainmentBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TKEntertainmentBookingRepository extends JpaRepository<TKEntertainmentBooking, Long> {
}
