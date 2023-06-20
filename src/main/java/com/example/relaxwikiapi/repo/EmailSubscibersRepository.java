package com.example.relaxwikiapi.repo;

import com.example.relaxwikiapi.entity.EmailSubscibers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailSubscibersRepository extends JpaRepository<EmailSubscibers,Integer> {
}
