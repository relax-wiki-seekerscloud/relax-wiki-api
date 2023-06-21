package com.example.relaxwikiapi.repository.hotel;

import com.example.relaxwikiapi.entity.GP_Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GP_OffersRepository extends JpaRepository<GP_Offers,Integer> {
}
