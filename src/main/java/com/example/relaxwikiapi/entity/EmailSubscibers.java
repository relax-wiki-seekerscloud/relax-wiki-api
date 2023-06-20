package com.example.relaxwikiapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class EmailSubscibers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subscriberId;

    private String email;

}
