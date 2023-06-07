package com.example.relaxwikiapi.entity.hotel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tk_hotel_room_type")
public class TKHotelRoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_room_type_id")
    private Long hotelRoomTypeID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    private TKHotel tkHotel;

    @Column(name = "main_description", nullable = false)
    private String mainDescription;

    @Column(name = "sub_description")
    private String subDescription;

    @Column(name = "price", nullable = false)
    private Double price;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "tkHotelRoomType")
    private Set<TKHotelRoomTypeFacility> tkHotelRoomTypeFacilities;

    public Set<TKHotelRoomTypeFacility> getTkHotelRoomTypeFacilities() {
        if (tkHotelRoomTypeFacilities == null) {
            tkHotelRoomTypeFacilities = new HashSet<>();
        }
        return tkHotelRoomTypeFacilities;
    }

    public void setTkHotelRoomTypeFacilities(Set<TKHotelRoomTypeFacility> tkHotelRoomTypeFacilities) {
        this.tkHotelRoomTypeFacilities = tkHotelRoomTypeFacilities;
    }
}
