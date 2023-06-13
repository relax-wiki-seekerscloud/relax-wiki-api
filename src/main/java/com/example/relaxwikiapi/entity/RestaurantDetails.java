package com.example.relaxwikiapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@ToString
@Entity
public class RestaurantDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String restaurantDesc;
    private String openingHours;
    private String contactPersonName;
    private String phoneNo;
    private String email;
    private String password;
    private String restaurantCategory;
    private LocalTime openTimeForm;
    private LocalTime openTimeTo;
    @Lob
    private byte[] photo;

    @ElementCollection
    private List<String> languages;

    @ElementCollection
    private List<String> mealsServed;

    @ElementCollection
    private List<String> offeredCuisine;

    @ElementCollection
    private List<String> paymentMethods;

    @ElementCollection
    private List<String> contactNumbers;

    @ElementCollection
    private List<String> photoUrls;

    @ElementCollection
    private List<String> parking;

    @ElementCollection
    private List<String> atmosphere;

    @ElementCollection
    private List<String> additional;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "restaurantDetails", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<AddOn> addOns = new ArrayList<AddOn>();

    public void addAddOn(AddOn addOn) {
        addOn.setRestaurantDetails(this);
        this.addOns.add(addOn);
    }
}
