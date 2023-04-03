package com.example.relaxwikiapi.repo;

import com.example.relaxwikiapi.entity.ActivityDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityDetailsRepository extends JpaRepository<ActivityDetails, Long> {
}
