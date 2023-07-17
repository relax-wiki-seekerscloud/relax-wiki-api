package com.example.relaxwikiapi.service;

import com.example.relaxwikiapi.entity.Advertisement;
import com.example.relaxwikiapi.entity.Taxi;
import com.example.relaxwikiapi.repo.AdvertisementRepository;
import com.example.relaxwikiapi.repo.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaxiService {
    @Autowired
    private TaxiRepository repo;

    public Taxi saveTaxi(Taxi taxi) {
        return repo.save(taxi);
    }

    public List<Taxi> getTaxis() {
        return repo.findAll();
    }

    // Define a method to get an Advertisement entity by its id
    public Taxi getTaxiById(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<Taxi> getTaxiByCategory(int id) {
        return repo.findByCategory(id);
    }

    // Define a method to delete an Advertisement entity by its id
    public String deleteTaxi(int id) {
        repo.deleteById(id);
        return "Taxi removed -> " + id;
    }

    // Define a method to update an Advertisement entity
    public Taxi updateTaxi(Taxi taxi) {
        // Find the existing Advertisement entity by its id
        Taxi existingTaxi = repo.findById(taxi.getId()).orElse(null);
        // If the existing Advertisement entity is not null, update its fields with the new values
        assert existingTaxi != null;
        existingTaxi.setVehicleNo(taxi.getVehicleNo());
        existingTaxi.setColor(taxi.getColor());
        existingTaxi.setContact(taxi.getContact());
        existingTaxi.setOwnerName(taxi.getOwnerName());
        existingTaxi.setCategory(taxi.getCategory());
        existingTaxi.setImage(taxi.getImage());
        //save and return the updated advertisement entity
        return repo.save(existingTaxi);
    }


}
