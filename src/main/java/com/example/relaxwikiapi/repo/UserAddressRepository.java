package com.example.relaxwikiapi.repo;
import com.example.relaxwikiapi.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
}
