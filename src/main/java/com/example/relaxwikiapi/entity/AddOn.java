package com.example.relaxwikiapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class AddOn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addOnId;
    private String category;
    private String subCategory;
    private String name;

    @ManyToOne(fetch= FetchType.LAZY)
    private HotelDetails hotelDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    private RestaurantDetails restaurantDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    private ActivityDetails activityDetails;
}
