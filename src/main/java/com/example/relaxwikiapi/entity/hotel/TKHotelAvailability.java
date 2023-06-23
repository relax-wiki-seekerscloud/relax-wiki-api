package com.example.relaxwikiapi.entity.hotel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tk_hotel_availability")
public class TKHotelAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "availability_id")
    private Long availabilityId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    private TKHotel tkHotel;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "available_state", nullable = false)
    private Boolean availableState;
}
