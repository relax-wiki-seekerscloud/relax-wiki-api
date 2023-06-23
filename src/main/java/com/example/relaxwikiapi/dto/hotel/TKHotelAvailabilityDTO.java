package com.example.relaxwikiapi.dto.hotel;

import com.example.relaxwikiapi.entity.hotel.TKHotelAvailability;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKHotelAvailabilityDTO {

    private Long availabilityId;

    private Long hotelID;

    private LocalDate date;

    private boolean availableState;

    public TKHotelAvailabilityDTO(TKHotelAvailability hotelAvailability) {
        this.availabilityId=hotelAvailability.getAvailabilityId();
        this.hotelID = hotelAvailability.getTkHotel().getHotelID();
        this.date=hotelAvailability.getDate();
        this.availableState=hotelAvailability.getAvailableState();

    }

}
