package com.example.relaxwikiapi.entity.hotel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tk_hotel_booking")
public class TKHotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_booking_id")
    private Long hotelBookingID;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "special_requests", nullable = false)
    private String specialRequests;

    @Column(name = "booking_date", nullable = false)
    private String bookingDate;

    @Column(name = "arrival_time", nullable = false)
    private String arrivalTime;

    @Column(name = "hotel_id", nullable = false)
    private Long hotelID;

    @Column(name = "hotel_room_type_id", nullable = false)
    private Long hotelRoomTypeID;
}
