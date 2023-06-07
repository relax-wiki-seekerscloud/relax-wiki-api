package com.example.relaxwikiapi.dto.hotel;

import com.example.relaxwikiapi.entity.hotel.TKHotelRoomTypeFacility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKHotelRoomTypeFacilityDTO {

    private Long hotelRoomTypeFacilityID;

    private Long hotelRoomTypeID;

    private String description;

    public TKHotelRoomTypeFacilityDTO(TKHotelRoomTypeFacility hotelRoomTypeFacility) {
        this.hotelRoomTypeFacilityID = hotelRoomTypeFacility.getHotelRoomTypeFacilityID();
        this.hotelRoomTypeID = hotelRoomTypeFacility.getTkHotelRoomType().getHotelRoomTypeID();
        this.description = hotelRoomTypeFacility.getDescription();
    }
}
