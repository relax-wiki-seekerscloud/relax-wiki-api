package com.example.relaxwikiapi.dto.hotel;

import com.example.relaxwikiapi.entity.hotel.TKHotelReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKHotelReviewDTO {

    private Long hotelReviewID;

    private Long hotelID;

    private String description;

    private String reviewerName;

    public TKHotelReviewDTO(TKHotelReview tkHotelReview) {
        this.hotelReviewID = tkHotelReview.getHotelReviewID();
        this.hotelID = tkHotelReview.getTkHotel().getHotelID();
        this.description = tkHotelReview.getDescription();
        this.reviewerName = tkHotelReview.getReviewerName();
    }
}
