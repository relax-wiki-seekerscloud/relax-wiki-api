package com.example.relaxwikiapi.dto.hotel;

import com.example.relaxwikiapi.constants.AppsConstants;

import java.util.ArrayList;
import java.util.List;

public class TKHotelSearchRQ {

    private String hotelLocation;

    private String hotelCheckin;

    private String hotelCheckout;

    private Integer numOfAdults;

    private Integer numOfChildren;

    private Integer hotelRooms;

    private List<AppsConstants.FilterByBudget> filterByBudgetArr;

    private List<AppsConstants.StarCategory> filterByRatingsArr;

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public String getHotelCheckin() {
        return hotelCheckin;
    }

    public void setHotelCheckin(String hotelCheckin) {
        this.hotelCheckin = hotelCheckin;
    }

    public String getHotelCheckout() {
        return hotelCheckout;
    }

    public void setHotelCheckout(String hotelCheckout) {
        this.hotelCheckout = hotelCheckout;
    }

    public Integer getNumOfAdults() {
        return numOfAdults;
    }

    public void setNumOfAdults(Integer numOfAdults) {
        this.numOfAdults = numOfAdults;
    }

    public Integer getNumOfChildren() {
        return numOfChildren;
    }

    public void setNumOfChildren(Integer numOfChildren) {
        this.numOfChildren = numOfChildren;
    }

    public Integer getHotelRooms() {
        return hotelRooms;
    }

    public void setHotelRooms(Integer hotelRooms) {
        this.hotelRooms = hotelRooms;
    }

    public List<AppsConstants.FilterByBudget> getFilterByBudgetArr() {
        if (filterByBudgetArr == null) {
            filterByBudgetArr = new ArrayList<>();
        }
        return filterByBudgetArr;
    }

    public void setFilterByBudgetArr(List<AppsConstants.FilterByBudget> filterByBudgetArr) {
        this.filterByBudgetArr = filterByBudgetArr;
    }

    public List<AppsConstants.StarCategory> getFilterByRatingsArr() {
        if (filterByRatingsArr == null) {
            filterByRatingsArr = new ArrayList<>();
        }
        return filterByRatingsArr;
    }

    public void setFilterByRatingsArr(List<AppsConstants.StarCategory> filterByRatingsArr) {
        this.filterByRatingsArr = filterByRatingsArr;
    }
}
