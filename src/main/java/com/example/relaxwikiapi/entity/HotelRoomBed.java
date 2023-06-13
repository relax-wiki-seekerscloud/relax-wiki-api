package com.example.relaxwikiapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class HotelRoomBed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bedId;
    private String bedType;

    @ManyToOne(fetch= FetchType.LAZY)
    private HotelRoom hotelRoom;
}

