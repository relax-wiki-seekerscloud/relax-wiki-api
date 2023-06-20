package com.example.relaxwikiapi.chatapplication.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelID;

    @Column(unique = true)
    private String hotelName;

}
