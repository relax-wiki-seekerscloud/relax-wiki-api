package com.example.relaxwikiapi.entity.hotel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GP_RecenltyViewedHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loginId;

    @ManyToOne
    @JoinColumn(name="hotelId",referencedColumnName = "regId")
    private GP_Hotel hotelInfo;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private GP_User gpUser;


}
