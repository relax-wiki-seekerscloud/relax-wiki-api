package com.example.relaxwikiapi.service.hotel;

import com.example.relaxwikiapi.dto.hotel.TKHotelBookingDTO;
import com.example.relaxwikiapi.dto.hotel.TKHotelDTO;
import com.example.relaxwikiapi.dto.hotel.TKHotelSearchRQ;
import com.example.relaxwikiapi.exception.AppsException;

import java.util.List;

public interface TKHotelService {

    List<TKHotelDTO> searchHotels(TKHotelSearchRQ searchRQ) throws AppsException;

    TKHotelDTO findHotelByID(Long hotelID) throws AppsException;

    TKHotelBookingDTO hotelBooking(TKHotelBookingDTO bookingDTO) throws AppsException;
}