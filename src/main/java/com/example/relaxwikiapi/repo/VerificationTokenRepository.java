package com.example.relaxwikiapi.repo;


import java.util.Optional;

import com.example.relaxwikiapi.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    Optional<VerificationToken> findFirstByConfirmationToken(String token);
}