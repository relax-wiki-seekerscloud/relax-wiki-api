package com.example.relaxwikiapi.entity;


import jakarta.persistence.GenerationType;
import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import  jakarta.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Advertisement {
    // mark ID field as primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private String type;
    private String resourceUrl;
    private int isVerified;
    private int status;
    private String businessName;
    private String businessType;
    private String  businessUrl;
    private String businessPhone;
    private String expireDate;
    private int budget;
}
