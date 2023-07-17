package com.example.relaxwikiapi.api;

import com.example.relaxwikiapi.entity.Booking;
import com.example.relaxwikiapi.entity.Taxi;
import com.example.relaxwikiapi.repo.BookingRepository;
import com.example.relaxwikiapi.service.BookingService;
import com.example.relaxwikiapi.service.FileStorageService;
import com.example.relaxwikiapi.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
@RestController
public class BookingController {

    @Autowired
    private BookingService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/booking")
    public Booking addBooking(@RequestBody Booking booking) {
        System.out.println(booking);
        return service.saveBooking(booking);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/booking")
    public Booking updateBooking(@RequestBody Booking booking) {
        return service.updateBooking(booking);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/booking/{id}")
    public String deleteBooking(@PathVariable int id) {
        return service.deleteBooking(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/booking")
    public List<Booking> findAllBooking() {
        return service.getBookings();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/booking-by-id/{id}")
    public Booking findBookingById(@PathVariable int id) {
        return service.getBookingById(id);
    }
}
