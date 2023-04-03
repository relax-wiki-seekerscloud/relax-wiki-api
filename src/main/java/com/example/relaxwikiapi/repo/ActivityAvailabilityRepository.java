package com.example.relaxwikiapi.repo;

import com.example.relaxwikiapi.entity.ActivityAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityAvailabilityRepository extends JpaRepository<ActivityAvailability, Long> {

}
