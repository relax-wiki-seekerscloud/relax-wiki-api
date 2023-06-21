package com.example.relaxwikiapi.repository.hotel;

import com.example.relaxwikiapi.entity.hotel.GP_Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GP_Hotel_Repository extends JpaRepository<GP_Hotel,String> {
}
