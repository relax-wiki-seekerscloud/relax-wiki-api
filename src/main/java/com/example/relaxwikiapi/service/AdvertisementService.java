package com.example.relaxwikiapi.service;

import com.example.relaxwikiapi.entity.Advertisement;
import com.example.relaxwikiapi.repo.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
// Mark this class as a Spring service component
@Service
public class  AdvertisementService {

    // Inject an instance of AdvertisementRepository using @Autowired
    @Autowired
    private AdvertisementRepository repo;

    // Define a method to save an Advertisement entity
    public Advertisement saveAdvertisement(Advertisement advertisement) {
        advertisement.setTimestamp(LocalDateTime.now());
        return repo.save(advertisement);
    }

    // Define a method to get all Advertisement entities
    public List<Advertisement> getAdvertisements() {
        return repo.findAll();
    }

    // Define a method to get an Advertisement entity by its id
    public Advertisement getAdvertisementById(int id) {
        return repo.findById(id).orElse(null);
    }

    // Define a method to delete an Advertisement entity by its id
    public String deleteAdvertisement(int id) {
        repo.deleteById(id);
        return "Advertisement removed -> " + id;
    }

    // Define a method to update an Advertisement entity
    public Advertisement updateAdvertisement(Advertisement advertisement) {
        // Find the existing Advertisement entity by its id
        Advertisement existingAdvertisement = repo.findById(advertisement.getId()).orElse(null);
        // If the existing Advertisement entity is not null, update its fields with the new values
        assert existingAdvertisement != null;
        existingAdvertisement.setTitle(advertisement.getTitle());
        existingAdvertisement.setDescription(advertisement.getDescription());
        existingAdvertisement.setType(advertisement.getType());
        existingAdvertisement.setResourceUrl(advertisement.getResourceUrl());
        existingAdvertisement.setIsVerified(advertisement.getIsVerified());
        existingAdvertisement.setStatus(advertisement.getStatus());
        existingAdvertisement.setBusinessName(advertisement.getBusinessName());
        existingAdvertisement.setBusinessType(advertisement.getBusinessType());
        existingAdvertisement.setBusinessUrl(advertisement.getBusinessUrl());
        existingAdvertisement.setBusinessPhone(advertisement.getBusinessPhone());
        existingAdvertisement.setExpireDate(advertisement.getExpireDate());
        existingAdvertisement.setBudget(advertisement.getBudget());
        existingAdvertisement.setPrice(advertisement.getPrice());
        existingAdvertisement.setTimestamp(advertisement.getTimestamp());

        //save and return the updated advertisement entity
        return repo.save(existingAdvertisement);
    }
}
