package com.example.relaxwikiapi.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Advertisement {
    // mark ID field as primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;//
    private String description;//
    private String type;// image or video
    private String resourceUrl;
    private String isVerified;
    private String status;
    private String businessName;//
    private String businessType;//
    private String  businessUrl;//
    private String businessAddress;//
    private String businessPhone;//
    private String expireDate;//
    private String budget;//
    private String price;//

    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}
