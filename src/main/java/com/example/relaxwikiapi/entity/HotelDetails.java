package com.example.relaxwikiapi.entity;


import jakarta.persistence.*;
import jakarta.validation.metadata.CascadableDescriptor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;
import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class HotelDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    private int starRating;
    private String contactPersonName;

    @Lob
    private String description;

    private String phoneNo;
    private String email;
    private String password;
    public String bookingCancelPeriod;
    public String bookingCancelCharge;
    public Boolean pets;
    public String petsCharge;
    public LocalTime checkInTimeFrom;
    public LocalTime checkInTimeTo;
    public LocalTime checkOutTimeFrom;
    public LocalTime checkOutTimeTo;
    @Lob
    private byte[] photo;

    @ElementCollection
    private List<String> contactNumbers;

    @ElementCollection
    private List<String> photoUrls;

    @ElementCollection
    private List<String> languages;

    @ElementCollection
    private List<String> paymentMethods;

    @ElementCollection
    private List<String> facilities;

    @ElementCollection
    private List<String> services;

    @ElementCollection
    private List<String> mostCommonAmenities;

    @ElementCollection
    private List<String> otherAmenities;

    @OneToMany(mappedBy = "hotelDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HotelRoom> rooms = new ArrayList<HotelRoom>();


    @OneToMany(mappedBy = "hotelDetails", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<AddOn> addOns = new ArrayList<AddOn>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public void addRoom(HotelRoom room) {
        room.setHotelDetails(this);
        this.rooms.add(room);
    }

    public void addAddOn(AddOn addOn) {
        addOn.setHotelDetails(this);
        this.addOns.add(addOn);
    }
}


