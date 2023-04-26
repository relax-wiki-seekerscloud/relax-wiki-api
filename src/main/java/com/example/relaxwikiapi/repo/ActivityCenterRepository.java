package com.example.relaxwikiapi.repo;

import com.example.relaxwikiapi.entity.ActivityCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActivityCenterRepository extends JpaRepository<ActivityCenter, Long> {
}
