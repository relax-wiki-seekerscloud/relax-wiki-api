package com.example.relaxwikiapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@ToString
@Entity

public class ActivityDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String activityCenterDesc;
    private String name;
    private String address;
    private String contactPersonName;
    private String tourDuration;
    private String entertainmentCategory;
    private String phoneNo;
    private String email;
    private String password;
    private LocalTime openTimeFrom;
    private LocalTime openTimeTo;
    private String bookingCancelPeriod;
    private String bookingCancelCharge;

    @ElementCollection
    private List<String>photoUrls;

    @Lob
    private byte[] photo;

    @ElementCollection
    private List<String> languages;

    @ElementCollection
    private List<String> services;

    @ElementCollection
    private List<String> mealsProvided;

    @ElementCollection
    private List<String> transportationMethods;

    private int lowestRateForOnePerson;

    @ElementCollection
    private List<String> paymentMethods;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "activityDetails",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<AddOn>addOns=new ArrayList<>();

    public void addAddOn(AddOn addOn){
        addOn.setActivityDetails(this);
        this.addOns.add(addOn);
    }
}
