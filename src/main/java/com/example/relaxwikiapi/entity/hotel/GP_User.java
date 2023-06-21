package com.example.relaxwikiapi.entity.hotel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GP_User {

    @Id
    private String userId;

    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

}
