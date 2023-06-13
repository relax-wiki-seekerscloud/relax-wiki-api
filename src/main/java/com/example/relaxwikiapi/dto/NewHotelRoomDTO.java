package com.example.relaxwikiapi.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class NewHotelRoomDTO {
    @NotEmpty
    private String roomType;

    @NotEmpty
    private String roomName;
    private String roomSize;

    @NotEmpty
    private String customRoomName;
    private int noOfPeople;
    private int roomCountFromRoomType;

    private String smokingPolicy;
    private int bedroomCount;
    private int livingRoomCount;
    private int bathroomCount;

    @NotEmpty
    private int pricePerNight;
    private List<HotelRoomBedDTO>beds;

    public List<HotelRoomBedDTO> getBeds() {
        return beds;
    }

    public void setBeds(List<HotelRoomBedDTO> beds) {
        this.beds = beds;
    }


    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(String roomSize) {
        this.roomSize = roomSize;
    }

    public String getCustomRoomName() {
        return customRoomName;
    }

    public void setCustomRoomName(String customRoomName) {
        this.customRoomName = customRoomName;
    }

    public int getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public int getRoomCountFromRoomType() {
        return roomCountFromRoomType;
    }

    public void setRoomCountFromRoomType(int roomCountFromRoomType) {
        this.roomCountFromRoomType = roomCountFromRoomType;
    }

    public String getSmokingPolicy() {
        return smokingPolicy;
    }

    public void setSmokingPolicy(String smokingPolicy) {
        this.smokingPolicy = smokingPolicy;
    }

    public int getBedroomCount() {
        return bedroomCount;
    }

    public void setBedroomCount(int bedroomCount) {
        this.bedroomCount = bedroomCount;
    }

    public int getLivingRoomCount() {
        return livingRoomCount;
    }

    public void setLivingRoomCount(int livingRoomCount) {
        this.livingRoomCount = livingRoomCount;
    }

    public int getBathroomCount() {
        return bathroomCount;
    }

    public void setBathroomCount(int bathroomCount) {
        this.bathroomCount = bathroomCount;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}
