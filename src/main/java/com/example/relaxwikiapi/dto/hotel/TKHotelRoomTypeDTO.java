package com.example.relaxwikiapi.dto.hotel;

import com.example.relaxwikiapi.entity.hotel.TKHotelRoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKHotelRoomTypeDTO {

    private Long hotelRoomTypeID;

    private Long hotelID;

    private String mainDescription;

    private String subDescription;

    private Double price;

    private List<TKHotelRoomTypeFacilityDTO> hotelRoomTypeFacilities;

    public TKHotelRoomTypeDTO(TKHotelRoomType roomType) {
        this.hotelRoomTypeID = roomType.getHotelRoomTypeID();
        this.hotelID = roomType.getTkHotel().getHotelID();
        this.mainDescription = roomType.getMainDescription();
        this.subDescription = roomType.getSubDescription();
        this.price = roomType.getPrice();
    }

    public List<TKHotelRoomTypeFacilityDTO> getHotelRoomTypeFacilities() {
        if (hotelRoomTypeFacilities == null) {
            hotelRoomTypeFacilities = new ArrayList<>();
        }
        return hotelRoomTypeFacilities;
    }

    public void setHotelRoomTypeFacilities(List<TKHotelRoomTypeFacilityDTO> hotelRoomTypeFacilities) {
        this.hotelRoomTypeFacilities = hotelRoomTypeFacilities;
    }
}
