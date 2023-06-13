package com.example.relaxwikiapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class HotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    private String roomType;
    private String roomName;
    private String roomSize;

    private String customRoomName;
    private int noOfPeople;
    private int roomCountFromRoomType;

    private String smokingPolicy;
    private int bedroomCount;
    private int livingRoomCount;
    private int bathroomCount;

    private int pricePerNight;

    @ManyToOne(fetch= FetchType.LAZY)
    private HotelDetails hotelDetails;

    @OneToMany(mappedBy = "hotelRoom",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HotelRoomBed> beds=new ArrayList<HotelRoomBed>();

    public void addBed(HotelRoomBed hotelRoomBed){
        hotelRoomBed.setHotelRoom(this);
        this.beds.add(hotelRoomBed);
    }
}
