package com.example.relaxwikiapi.repo;

import com.example.relaxwikiapi.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

// Define an interface that extends the JpaRepository interface
// for the Advertisement entity with Integer as the type of its primary key
public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
    // Define a method to find an advertisement by its title
    Advertisement findByTitle(String title);

}
