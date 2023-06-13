package com.example.relaxwikiapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String gender;
    private String password;

    @OneToMany(targetEntity = UserAddress.class, cascade = CascadeType.ALL )
    @JoinColumn(name= "ua_fk", referencedColumnName = "id")
    private List<UserAddress> address;

    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<HotelDetails> hotels;

    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<RestaurantDetails> restaurants;

    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<ActivityDetails> activities;

    public User(String userFirstName, String userLastName, String userEmail, String userPassword) {
        this.firstName = userFirstName;
        this.lastName = userLastName;
        this.email = userEmail;
        this.password = userPassword;
    }
}
