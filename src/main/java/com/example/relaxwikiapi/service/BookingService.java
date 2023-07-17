package com.example.relaxwikiapi.service;

import com.example.relaxwikiapi.entity.Advertisement;
import com.example.relaxwikiapi.entity.Booking;
import com.example.relaxwikiapi.repo.AdvertisementRepository;
import com.example.relaxwikiapi.repo.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository repo;

    // Define a method to save an Advertisement entity
    public Booking saveBooking(Booking booking) {
        return repo.save(booking);
    }

    // Define a method to get all Advertisement entities
    public List<Booking> getBookings() {
        return repo.findAll();
    }

    // Define a method to get an Advertisement entity by its id
    public Booking getBookingById(int id) {
        return repo.findById(id).orElse(null);
    }

    // Define a method to delete an Advertisement entity by its id
    public String deleteBooking(int id) {
        repo.deleteById(id);
        return "Booking removed -> " + id;
    }

    // Define a method to update an Advertisement entity
    public Booking updateBooking(Booking booking) {
        // Find the existing Advertisement entity by its id
        Booking existingBooking = repo.findById(booking.getId()).orElse(null);
        // If the existing Advertisement entity is not null, update its fields with the new values
        assert existingBooking != null;
        existingBooking.setDestination(existingBooking.getDestination());
        existingBooking.setDate(existingBooking.getDate());
        existingBooking.setPickupLocation(existingBooking.getPickupLocation());
        existingBooking.setPickupTime(existingBooking.getPickupTime());
        existingBooking.setPeopleCount(existingBooking.getPeopleCount());
        existingBooking.setFirstName(existingBooking.getFirstName());
        existingBooking.setLastName(existingBooking.getLastName());
        existingBooking.setEmail(existingBooking.getEmail());
        existingBooking.setRequest(existingBooking.getRequest());
        existingBooking.setDistance(existingBooking.getDistance());
        existingBooking.setPrice(existingBooking.getPrice());
        existingBooking.setVehicleId(existingBooking.getVehicleId());
        //save and return the updated advertisement entity
        return repo.save(existingBooking);
    }
}
