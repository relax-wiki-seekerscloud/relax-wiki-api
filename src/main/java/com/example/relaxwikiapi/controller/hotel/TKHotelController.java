package com.example.relaxwikiapi.controller.hotel;

import com.example.relaxwikiapi.constants.AppsConstants;
import com.example.relaxwikiapi.dto.common.ResponseDTO;
import com.example.relaxwikiapi.dto.hotel.TKHotelBookingDTO;
import com.example.relaxwikiapi.dto.hotel.TKHotelDTO;
import com.example.relaxwikiapi.dto.hotel.TKHotelSearchRQ;
import com.example.relaxwikiapi.exception.AppsException;
import com.example.relaxwikiapi.service.hotel.TKHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hotel")
public class TKHotelController {

    @Autowired
    private TKHotelService tkHotelService;

    @PostMapping(value = "/searchHotels", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<List<TKHotelDTO>>> searchHotels(@RequestBody TKHotelSearchRQ searchRQ) {
        ResponseDTO<List<TKHotelDTO>> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            List<TKHotelDTO> allHotels = this.tkHotelService.searchHotels(searchRQ);

            response.setResult(allHotels);
            response.setStatus(AppsConstants.ResponseStatus.SUCCESS);
            httpStatus = HttpStatus.OK;

        } catch (AppsException e) {
            response.setStatus(AppsConstants.ResponseStatus.FAILED);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping(value = "/findHotelByID/{hotelID}", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<TKHotelDTO>> findHotelByID(@PathVariable Long hotelID) {
        ResponseDTO<TKHotelDTO> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            TKHotelDTO hotelDTO = this.tkHotelService.findHotelByID(hotelID);

            response.setResult(hotelDTO);
            response.setStatus(AppsConstants.ResponseStatus.SUCCESS);
            httpStatus = HttpStatus.OK;

        } catch (AppsException e) {
            response.setStatus(AppsConstants.ResponseStatus.FAILED);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @PostMapping(value = "/hotelBooking", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<TKHotelBookingDTO>> hotelBooking(@RequestBody TKHotelBookingDTO bookingDTO) {
        ResponseDTO<TKHotelBookingDTO> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            TKHotelBookingDTO hotelBooking = this.tkHotelService.hotelBooking(bookingDTO);

            response.setResult(hotelBooking);
            response.setStatus(AppsConstants.ResponseStatus.SUCCESS);
            httpStatus = HttpStatus.OK;

        } catch (AppsException e) {
            response.setStatus(AppsConstants.ResponseStatus.FAILED);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, httpStatus);
    }
}
