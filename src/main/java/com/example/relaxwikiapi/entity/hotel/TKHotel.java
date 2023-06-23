package com.example.relaxwikiapi.entity.hotel;

import com.example.relaxwikiapi.constants.AppsConstants;
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
@Table(name = "tk_hotel")
public class TKHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long hotelID;

    @Column(name = "hotel_name", nullable = false)
    private String hotelName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "main_description", nullable = false)
    private String mainDescription;

    @Column(name = "sub_description_one", nullable = false)
    private String subDescriptionOne;

    @Column(name = "sub_description_two", nullable = false)
    private String subDescriptionTwo;

    @Enumerated(EnumType.STRING)
    @Column(name = "hotel_condition", nullable = false, length = 50)
    private AppsConstants.HotelCondition hotelCondition;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "number_of_rooms", nullable = false)
    private Integer numberOfRooms;

    @Enumerated(EnumType.STRING)
    @Column(name = "star_category", nullable = false, length = 50)
    private AppsConstants.StarCategory starCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "has_free_cancellation", nullable = false, length = 2)
    private AppsConstants.YesNo hasFreeCancellation;

    @Enumerated(EnumType.STRING)
    @Column(name = "has_free_wifi", nullable = false, length = 2)
    private AppsConstants.YesNo hasFreeWifi;

    @Enumerated(EnumType.STRING)
    @Column(name = "has_city_view", nullable = false, length = 2)
    private AppsConstants.YesNo hasCityView;

    @Enumerated(EnumType.STRING)
    @Column(name = "has_air_conditioning", nullable = false, length = 2)
    private AppsConstants.YesNo hasAirConditioning;

    @Enumerated(EnumType.STRING)
    @Column(name = "has_bathtub", nullable = false, length = 2)
    private AppsConstants.YesNo hasBathtub;

    @Enumerated(EnumType.STRING)
    @Column(name = "has_safety_deposit_box", nullable = false, length = 2)
    private AppsConstants.YesNo hasSafetyDepositBox;

    @Enumerated(EnumType.STRING)
    @Column(name = "has_parking_on_site", nullable = false, length = 2)
    private AppsConstants.YesNo hasParkingOnSite;

    @Enumerated(EnumType.STRING)
    @Column(name = "has_swimming_pool", nullable = false, length = 2)
    private AppsConstants.YesNo hasSwimmingPool;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "tkHotel")
    private Set<TKHotelReview> tkHotelReviews;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "tkHotel")
    private Set<TKHotelImage> tkHotelImages;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "tkHotel")
    private Set<TKHotelRoomType> tkHotelRoomTypes;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "tkHotel")
    private Set<TKHotelAvailability> tkHotelAvailabilities;

    public Set<TKHotelReview> getTkHotelReviews() {
        if (tkHotelReviews == null) {
            tkHotelReviews = new HashSet<>();
        }
        return tkHotelReviews;
    }

    public void setTkHotelReviews(Set<TKHotelReview> tkHotelReviews) {
        this.tkHotelReviews = tkHotelReviews;
    }

    public Set<TKHotelImage> getTkHotelImages() {
        if (tkHotelImages == null) {
            tkHotelImages = new HashSet<>();
        }
        return tkHotelImages;
    }

    public void setTkHotelImages(Set<TKHotelImage> tkHotelImages) {
        this.tkHotelImages = tkHotelImages;
    }

    public Set<TKHotelRoomType> getTkHotelRoomTypes() {
        if (tkHotelRoomTypes == null) {
            tkHotelRoomTypes = new HashSet<>();
        }
        return tkHotelRoomTypes;
    }

    public void setTkHotelRoomTypes(Set<TKHotelRoomType> tkHotelRoomTypes) {
        this.tkHotelRoomTypes = tkHotelRoomTypes;
    }
}
