package com.example.relaxwikiapi.dto;

import jakarta.validation.constraints.NotEmpty;

public class HotelRoomBedDTO {
    @NotEmpty
    private String bedType;
    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }
}
