package com.example.relaxwikiapi.repo;

import com.example.relaxwikiapi.entity.Advertisement;
import com.example.relaxwikiapi.entity.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaxiRepository extends JpaRepository<Taxi, Integer> {
    List<Taxi> findByCategory(int id);
}
