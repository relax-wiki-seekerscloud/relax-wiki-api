package com.example.relaxwikiapi.repo;

import com.example.relaxwikiapi.entity.HotelDetails;
import com.example.relaxwikiapi.entity.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoom, Long> {
}
