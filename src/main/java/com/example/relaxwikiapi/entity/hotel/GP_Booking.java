package com.example.relaxwikiapi.entity.hotel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GP_Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    private Date bookingDate;

    @ManyToOne
    @JoinColumn(name="hotelId",referencedColumnName = "regId")
    private GP_Hotel hotelInfo;

    private int amount;
}