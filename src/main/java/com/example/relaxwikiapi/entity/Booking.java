package com.example.relaxwikiapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String destination;//
    private String date;//
    private String pickupLocation;// image or video
    private String pickupTime;
    private String peopleCount;
    private String firstName;
    private String lastName;
    private String distance;
    private String price;
    private String email;
    private String request;
    private String vehicleId;
}
