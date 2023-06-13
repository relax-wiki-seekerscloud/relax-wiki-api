package com.example.relaxwikiapi.entity.entertainment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tk_entertainment_booking")
public class TKEntertainmentBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entertainment_booking_id")
    private Long entertainmentBookingID;

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

    @Column(name = "entertainment_id", nullable = false)
    private Long entertainmentID;
}
