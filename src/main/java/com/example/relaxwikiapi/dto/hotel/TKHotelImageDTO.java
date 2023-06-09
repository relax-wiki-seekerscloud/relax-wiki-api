package com.example.relaxwikiapi.dto.hotel;

import com.example.relaxwikiapi.entity.hotel.TKHotelImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKHotelImageDTO {

    private Long hotelImageID;

    private Long hotelID;

    private Integer displayOrder;

    private String imageURL;

    public TKHotelImageDTO(TKHotelImage hotelImage) {
        this.hotelImageID = hotelImage.getHotelImageID();
        this.hotelID = hotelImage.getTkHotel().getHotelID();
        this.displayOrder = hotelImage.getDisplayOrder();
        this.imageURL = hotelImage.getImageURL();
    }
}
