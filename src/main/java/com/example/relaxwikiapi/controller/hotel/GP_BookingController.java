package com.example.relaxwikiapi.controller.hotel;


import com.example.relaxwikiapi.chatapplication.Exception.ResourceNotFoundException;
import com.example.relaxwikiapi.entity.hotel.GP_Booking;
import com.example.relaxwikiapi.entity.hotel.GP_Hotel;
import com.example.relaxwikiapi.repository.hotel.GP_BookingRepository;
import com.example.relaxwikiapi.repository.hotel.GP_Hotel_Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/bookings")
public class GP_BookingController {

    @Autowired
    private GP_BookingRepository gp_bookingRepository;

    @Autowired
    private GP_Hotel_Repository gp_hotel_repository;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/getListOfBookingsOfGivenHotel/{hotelId}")
    public int[] getListOfBookingsOfGivenHotel(@PathVariable String hotelId) {
        List<GP_Booking> getBookingByBookingId = this.gp_bookingRepository.findAll();
        List<GP_Booking> noOfBookingsOfGivenHotel = new ArrayList<>();

        for(GP_Booking booking : getBookingByBookingId){
            if(booking.getHotelInfo().getRegId().equals(hotelId)){
                noOfBookingsOfGivenHotel.add(booking);
            }
        }
        return this.getBookingCountOfHotel(noOfBookingsOfGivenHotel);
    }


    public int[] getBookingCountOfHotel(List<GP_Booking> bookings) {

        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        Date startDate = calendar.getTime();

        int[] counts = new int[7];

        for (GP_Booking booking : bookings) {
            Date bookingDate = booking.getBookingDate();

            if (bookingDate.after(startDate) && bookingDate.before(currentDate)) {
                int index = (int) ((bookingDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000));

                counts[index]++;
            }
        }

        return counts;
    }




}
