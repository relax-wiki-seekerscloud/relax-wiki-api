package com.example.relaxwikiapi.controller.entertainment;

import com.example.relaxwikiapi.constants.AppsConstants;
import com.example.relaxwikiapi.dto.common.ResponseDTO;
import com.example.relaxwikiapi.dto.entertainment.TKEntertainmentBookingDTO;
import com.example.relaxwikiapi.dto.entertainment.TKEntertainmentDTO;
import com.example.relaxwikiapi.dto.entertainment.TKEntertainmentSearchRQ;
import com.example.relaxwikiapi.exception.AppsException;
import com.example.relaxwikiapi.service.entertainment.TKEntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/entertainment")
public class TKEntertainmentController {

    @Autowired
    private TKEntertainmentService entertainmentService;

    @PostMapping(value = "/searchEntertainments", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<List<TKEntertainmentDTO>>> searchEntertainments(@RequestBody TKEntertainmentSearchRQ searchRQ) {
        ResponseDTO<List<TKEntertainmentDTO>> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            List<TKEntertainmentDTO> allEntertainments = this.entertainmentService.searchEntertainments(searchRQ);

            response.setResult(allEntertainments);
            response.setStatus(AppsConstants.ResponseStatus.SUCCESS);
            httpStatus = HttpStatus.OK;

        } catch (AppsException e) {
            response.setStatus(AppsConstants.ResponseStatus.FAILED);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping(value = "/findEntertainmentByID/{entertainmentID}", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<TKEntertainmentDTO>> findEntertainmentByID(@PathVariable Long entertainmentID) {
        ResponseDTO<TKEntertainmentDTO> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            TKEntertainmentDTO entertainmentDTO = this.entertainmentService.findEntertainmentByID(entertainmentID);

            response.setResult(entertainmentDTO);
            response.setStatus(AppsConstants.ResponseStatus.SUCCESS);
            httpStatus = HttpStatus.OK;

        } catch (AppsException e) {
            response.setStatus(AppsConstants.ResponseStatus.FAILED);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @PostMapping(value = "/entertainmentBooking", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<TKEntertainmentBookingDTO>> entertainmentBooking(@RequestBody TKEntertainmentBookingDTO bookingDTO) {
        ResponseDTO<TKEntertainmentBookingDTO> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            TKEntertainmentBookingDTO booking = this.entertainmentService.entertainmentBooking(bookingDTO);

            response.setResult(booking);
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
