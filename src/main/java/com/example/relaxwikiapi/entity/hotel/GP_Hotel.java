package com.example.relaxwikiapi.entity.hotel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GP_Hotel {

    @Id
    private String regId;
    private String Address;
    private String Description;
    private String hotelName;
    private String imagePath;

}
