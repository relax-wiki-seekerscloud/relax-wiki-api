package com.example.relaxwikiapi.repo;

import com.example.relaxwikiapi.entity.TaxiCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiCategoryRepository extends JpaRepository<TaxiCategory, Integer> {
}
