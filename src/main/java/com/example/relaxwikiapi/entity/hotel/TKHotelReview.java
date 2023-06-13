package com.example.relaxwikiapi.entity.hotel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tk_hotel_review")
public class TKHotelReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_review_id")
    private Long hotelReviewID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    private TKHotel tkHotel;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "reviewer_name", nullable = false)
    private String reviewerName;
}
