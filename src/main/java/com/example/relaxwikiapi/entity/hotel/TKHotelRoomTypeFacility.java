package com.example.relaxwikiapi.entity.hotel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tk_hotel_room_type_facility")
public class TKHotelRoomTypeFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_room_type_facility_id")
    private Long hotelRoomTypeFacilityID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_room_type_id")
    private TKHotelRoomType tkHotelRoomType;

    @Column(name = "description", nullable = false)
    private String description;
}
