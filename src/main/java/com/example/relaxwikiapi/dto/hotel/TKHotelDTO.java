package com.example.relaxwikiapi.dto.hotel;

import com.example.relaxwikiapi.constants.AppsConstants;
import com.example.relaxwikiapi.entity.hotel.TKHotel;
import com.example.relaxwikiapi.entity.hotel.TKHotelImage;
import com.example.relaxwikiapi.entity.hotel.TKHotelReview;
import com.example.relaxwikiapi.entity.hotel.TKHotelRoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKHotelDTO {

    private Long hotelID;

    private String address;

    private String hotelName;

    private String mainDescription;

    private String subDescriptionOne;

    private String subDescriptionTwo;

    private AppsConstants.HotelCondition hotelCondition;

    private Double price;

    private Integer numberOfRooms;

    private AppsConstants.StarCategory starCategory;

    private AppsConstants.YesNo hasFreeCancellation;

    private AppsConstants.YesNo hasFreeWifi;

    private AppsConstants.YesNo hasCityView;

    private AppsConstants.YesNo hasAirConditioning;

    private AppsConstants.YesNo hasBathtub;

    private AppsConstants.YesNo hasSafetyDepositBox;

    private AppsConstants.YesNo hasParkingOnSite;

    private AppsConstants.YesNo hasSwimmingPool;

    private List<TKHotelReviewDTO> hotelReviewList;

    private List<TKHotelImageDTO> hotelImageList;

    private List<TKHotelRoomTypeDTO> hotelRoomTypeList;

    public TKHotelDTO(TKHotel tkHotel) {
        this.hotelID = tkHotel.getHotelID();
        this.hotelName = tkHotel.getHotelName();
        this.address = tkHotel.getAddress();
        this.mainDescription = tkHotel.getMainDescription();
        this.subDescriptionOne = tkHotel.getSubDescriptionOne();
        this.subDescriptionTwo = tkHotel.getSubDescriptionTwo();
        this.hotelCondition = tkHotel.getHotelCondition();
        this.price = tkHotel.getPrice();
        this.numberOfRooms = tkHotel.getNumberOfRooms();
        this.starCategory = tkHotel.getStarCategory();
        this.hasFreeCancellation = tkHotel.getHasFreeCancellation();
        this.hasFreeWifi = tkHotel.getHasFreeWifi();
        this.hasCityView = tkHotel.getHasCityView();
        this.hasAirConditioning = tkHotel.getHasAirConditioning();
        this.hasBathtub = tkHotel.getHasBathtub();
        this.hasSafetyDepositBox = tkHotel.getHasSafetyDepositBox();
        this.hasParkingOnSite = tkHotel.getHasParkingOnSite();
        this.hasSwimmingPool = tkHotel.getHasSwimmingPool();

        for (TKHotelReview hotelReview : tkHotel.getTkHotelReviews()) {
            this.getHotelReviewList().add(new TKHotelReviewDTO(hotelReview));
        }

        for (TKHotelImage hotelImage : tkHotel.getTkHotelImages()) {
            this.getHotelImageList().add(new TKHotelImageDTO(hotelImage));
        }

        for (TKHotelRoomType roomType : tkHotel.getTkHotelRoomTypes()) {
            this.getHotelRoomTypeList().add(new TKHotelRoomTypeDTO(roomType));
        }
    }

    public List<TKHotelReviewDTO> getHotelReviewList() {
        if (hotelReviewList == null) {
            hotelReviewList = new ArrayList<>();
        }
        return hotelReviewList;
    }

    public void setHotelReviewList(List<TKHotelReviewDTO> hotelReviewList) {
        this.hotelReviewList = hotelReviewList;
    }

    public List<TKHotelImageDTO> getHotelImageList() {
        if (hotelImageList == null) {
            hotelImageList = new ArrayList<>();
        }
        return hotelImageList;
    }

    public void setHotelImageList(List<TKHotelImageDTO> hotelImageList) {
        this.hotelImageList = hotelImageList;
    }

    public List<TKHotelRoomTypeDTO> getHotelRoomTypeList() {
        if (hotelRoomTypeList == null) {
            hotelRoomTypeList = new ArrayList<>();
        }
        return hotelRoomTypeList;
    }

    public void setHotelRoomTypeList(List<TKHotelRoomTypeDTO> hotelRoomTypeList) {
        this.hotelRoomTypeList = hotelRoomTypeList;
    }
}
