package com.example.relaxwikiapi.repository.entertainment;

import com.example.relaxwikiapi.entity.entertainment.TKEntertainment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TKEntertainmentRepository extends JpaRepository<TKEntertainment, Long> {
}
