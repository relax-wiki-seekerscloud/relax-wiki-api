package com.example.relaxwikiapi.service;

import com.example.relaxwikiapi.entity.Taxi;
import com.example.relaxwikiapi.entity.TaxiCategory;
import com.example.relaxwikiapi.repo.TaxiCategoryRepository;
import com.example.relaxwikiapi.repo.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaxiCategoryService {
    @Autowired
    private TaxiCategoryRepository repo;

    public TaxiCategory saveTaxiCategory(TaxiCategory taxiCategory) {
        return repo.save(taxiCategory);
    }

    public List<TaxiCategory> getTaxiCategories() {
        return repo.findAll();
    }

    // Define a method to get an Advertisement entity by its id
    public TaxiCategory getTaxiCategoryById(int id) {
        return repo.findById(id).orElse(null);
    }

    // Define a method to delete an Advertisement entity by its id
    public String deleteTaxiCategory(int id) {
        repo.deleteById(id);
        return "Taxi Category removed -> " + id;
    }

    // Define a method to update an Advertisement entity
    public TaxiCategory updateTaxiCategory(TaxiCategory taxiCategory) {
        // Find the existing Advertisement entity by its id
        TaxiCategory existingTaxiCategory = repo.findById(taxiCategory.getId()).orElse(null);
        // If the existing Advertisement entity is not null, update its fields with the new values
        assert existingTaxiCategory != null;
        existingTaxiCategory.setName(taxiCategory.getName());
        existingTaxiCategory.setBaseFair(taxiCategory.getBaseFair());
        existingTaxiCategory.setWaitingFair(taxiCategory.getWaitingFair());
        existingTaxiCategory.setFairPerKm(taxiCategory.getFairPerKm());
        existingTaxiCategory.setImage(taxiCategory.getImage());
        existingTaxiCategory.setMaxPeople(taxiCategory.getMaxPeople());

        //save and return the updated advertisement entity
        return repo.save(existingTaxiCategory);
    }
}
