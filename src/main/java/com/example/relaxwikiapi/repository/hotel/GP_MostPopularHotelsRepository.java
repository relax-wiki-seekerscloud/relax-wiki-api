package com.example.relaxwikiapi.repository.hotel;

import com.example.relaxwikiapi.entity.hotel.GP_MostPopularHotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GP_MostPopularHotelsRepository extends JpaRepository<GP_MostPopularHotels,Integer> {
}
