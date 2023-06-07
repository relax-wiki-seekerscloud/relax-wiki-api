package com.example.relaxwikiapi.controller.restaurant;

import com.example.relaxwikiapi.constants.AppsConstants;
import com.example.relaxwikiapi.dto.common.ResponseDTO;
import com.example.relaxwikiapi.dto.restaurant.TKRestaurantDTO;
import com.example.relaxwikiapi.dto.restaurant.TKRestaurantSearchRQ;
import com.example.relaxwikiapi.exception.AppsException;
import com.example.relaxwikiapi.service.restaurant.TKRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/restaurant")
public class TKRestaurantController {

    @Autowired
    private TKRestaurantService restaurantService;

    @PostMapping(value = "/searchRestaurants", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<List<TKRestaurantDTO>>> searchRestaurants(@RequestBody TKRestaurantSearchRQ searchRQ) {
        ResponseDTO<List<TKRestaurantDTO>> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            List<TKRestaurantDTO> allHotels = this.restaurantService.searchRestaurants(searchRQ);

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

    @GetMapping(value = "/findRestaurantByID/{restaurantID}", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<TKRestaurantDTO>> findRestaurantByID(@PathVariable Long restaurantID) {
        ResponseDTO<TKRestaurantDTO> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            TKRestaurantDTO hotelDTO = this.restaurantService.findRestaurantByID(restaurantID);

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
}
