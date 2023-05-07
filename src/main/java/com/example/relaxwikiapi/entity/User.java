package com.example.relaxwikiapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

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


    public User(String userFirstName, String userLastName, String userEmail, String userPassword) {
        this.firstName = userFirstName;
        this.lastName = userLastName;
        this.email = userEmail;
        this.password = userPassword;
    }
}
