package com.example.relaxwikiapi.chatapplication.Entity;

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
public class ChatIDsInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatID;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private UserInfo userInfo;


    @ManyToOne
    @JoinColumn(name = "HotelID", referencedColumnName = "HotelID")
    private HotelInfo hotelInfo;

}
