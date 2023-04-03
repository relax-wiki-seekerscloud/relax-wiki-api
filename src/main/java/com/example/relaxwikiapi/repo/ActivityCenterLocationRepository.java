package com.example.relaxwikiapi.repo;

import com.example.relaxwikiapi.entity.ActivityCenterLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActivityCenterLocationRepository extends JpaRepository<ActivityCenterLocation, Long> {

}
