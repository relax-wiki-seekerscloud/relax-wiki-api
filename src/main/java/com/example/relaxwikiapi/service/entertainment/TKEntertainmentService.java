package com.example.relaxwikiapi.service.entertainment;

import com.example.relaxwikiapi.dto.entertainment.TKEntertainmentBookingDTO;
import com.example.relaxwikiapi.dto.entertainment.TKEntertainmentDTO;
import com.example.relaxwikiapi.dto.entertainment.TKEntertainmentSearchRQ;
import com.example.relaxwikiapi.exception.AppsException;

import java.util.List;

public interface TKEntertainmentService {
    List<TKEntertainmentDTO> searchEntertainments(TKEntertainmentSearchRQ searchRQ) throws AppsException;

    TKEntertainmentDTO findEntertainmentByID(Long entertainmentID) throws AppsException;

    TKEntertainmentBookingDTO entertainmentBooking(TKEntertainmentBookingDTO bookingDTO) throws AppsException;
}
