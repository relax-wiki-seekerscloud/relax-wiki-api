package com.example.relaxwikiapi.repo;

import com.example.relaxwikiapi.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {


    @Query("SELECT a FROM Activity a JOIN a.activityCenter ac " +
            "JOIN ac.activityCenterLocation acl " +
            "JOIN a.activityAvailability av " +
            "WHERE acl.city = :city AND av.availabilityState = true " +
            "AND av.availableSlots >= :numOfPeople AND av.date = :date")
    List<Activity> findByCityPeopleDate(@Param("city") String city, @Param("numOfPeople") int numOfPeople, @Param("date") LocalDate date);

}
