package com.example.relaxwikiapi.dto;

import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

public class NewRestaurantDTO {
    @NotEmpty
    @Size(min = 3, message = "Invalid restaurant name.")
    private String restaurantName;
    private String restaurantDesc;
    private String restaurantCategory;
    @NotEmpty
    @Size(min = 3, message = "Invalid name")
    private String contactPersonName;

    @NotEmpty
    private String streetAddress;
    private String addressLine2;

    @NotEmpty
    private String country;

    @NotEmpty
    private String city;
    private String postalCode;

    private LocalTime openTimeFrom;
    private LocalTime openTimeTo;

    public LocalTime getOpenTimeFrom() {
        return openTimeFrom;
    }

    public void setOpenTimeFrom(LocalTime openTimeFrom) {
        this.openTimeFrom = openTimeFrom;
    }

    public LocalTime getOpenTimeTo() {
        return openTimeTo;
    }

    public void setOpenTimeTo(LocalTime openTimeTo) {
        this.openTimeTo = openTimeTo;
    }

    //    @NotEmpty
    private List<String> contactNumbers;
    //    @NotEmpty
    private List<String> photoUrls;
    private List<String> languages;

    private List<String> paymentMethods;
    private List<String> mealsServed;
    private List<String> offeredCuisine;
    private List<AddOnDTO> addOns;
    private List<String> parking;
    private List<String> atmosphere;
    private List<String> additional;

    public List<String> getParking() {
        return parking;
    }

    public void setParking(List<String> parking) {
        this.parking = parking;
    }

    public List<String> getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(List<String> atmosphere) {
        this.atmosphere = atmosphere;
    }

    public List<String> getAdditional() {
        return additional;
    }

    public void setAdditional(List<String> additional) {
        this.additional = additional;
    }

    public List<AddOnDTO> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<AddOnDTO> addOns) {
        this.addOns = addOns;
    }

    public List<String> getOfferedCuisine() {
        return offeredCuisine;
    }

    public void setOfferedCuisine(List<String> offeredCuisine) {
        this.offeredCuisine = offeredCuisine;
    }

    public String getRestaurantCategory() {
        return restaurantCategory;
    }

    public void setRestaurantCategory(String restaurantCategory) {
        this.restaurantCategory = restaurantCategory;
    }

    public List<String> getMealsServed() {
        return mealsServed;
    }

    public void setMealsServed(List<String> mealsServed) {
        this.mealsServed = mealsServed;
    }

    public List<String> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<String> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantDesc() {
        return restaurantDesc;
    }

    public void setRestaurantDesc(String restaurantDesc) {
        this.restaurantDesc = restaurantDesc;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<String> getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(List<String> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}
