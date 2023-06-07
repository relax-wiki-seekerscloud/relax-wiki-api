package com.example.relaxwikiapi.dto.hotel;

import com.example.relaxwikiapi.entity.hotel.TKHotelBooking;

public class TKHotelBookingDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String specialRequests;

    private String arrivalTime;

    private String bookingDate;

    private Long hotelID;

    private Long hotelRoomTypeID;

    public TKHotelBookingDTO() {
    }

    public TKHotelBookingDTO(TKHotelBooking booking) {
        this.firstName = booking.getFirstName();
        this.lastName = booking.getLastName();
        this.email = booking.getEmail();
        this.specialRequests = booking.getSpecialRequests();
        this.arrivalTime = booking.getArrivalTime();
        this.bookingDate = booking.getBookingDate();
        this.hotelID = booking.getHotelID();
        this.hotelRoomTypeID = booking.getHotelRoomTypeID();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Long getHotelID() {
        return hotelID;
    }

    public void setHotelID(Long hotelID) {
        this.hotelID = hotelID;
    }

    public Long getHotelRoomTypeID() {
        return hotelRoomTypeID;
    }

    public void setHotelRoomTypeID(Long hotelRoomTypeID) {
        this.hotelRoomTypeID = hotelRoomTypeID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
}
