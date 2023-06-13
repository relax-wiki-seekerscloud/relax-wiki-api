package com.example.relaxwikiapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;
import java.util.List;

public class NewHotelDTO {
    @NotEmpty
    @Size(min = 3, message = "Invalid hotel name.")
    private String hotelName;
    private int starRating;
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

    //    @NotEmpty
    private List<String> contactNumbers;

    //    @NotEmpty
    private List<String> photoUrls;
    private List<String> languages;
    private List<String> facilities;
    private List<String> services;
    private List<String> paymentMethods;
    private List<String> mostCommonAmenities;
    private List<String> roomAmenities;
    private List<String> foodAndDrinkAmenities;
    private List<String> entertainmentAndFamilyServicesAmenities;
    private List<String> mediaAndTechnologyAmenities;
    private List<String> bathroomAmenities;
    private List<String> otherAmenities;
    private List<String> roomAccessibilityAmenities;
    private List<String> safetyAndSecurityAmenities;
    private List<String> outdoorAmenities;
    private List<String> servicesAndExtraAmenities;
    private List<NewHotelRoomDTO> rooms;
    private List<AddOnDTO> addOns;
    public String bookingCancelPeriod;
    public String bookingCancelCharge;
    public Boolean pets;
    public String petsCharge;
    public LocalTime checkInTimeFrom;
    public LocalTime checkInTimeTo;
    public LocalTime checkOutTimeFrom;
    public LocalTime checkOutTimeTo;

    public List<String> getServicesAndExtraAmenities() {
        return servicesAndExtraAmenities;
    }

    public void setServicesAndExtraAmenities(List<String> servicesAndExtraAmenities) {
        this.servicesAndExtraAmenities = servicesAndExtraAmenities;
    }

    public List<String> getOutdoorAmenities() {
        return outdoorAmenities;
    }

    public void setOutdoorAmenities(List<String> outdoorAmenities) {
        this.outdoorAmenities = outdoorAmenities;
    }

    public List<String> getSafetyAndSecurityAmenities() {
        return safetyAndSecurityAmenities;
    }

    public void setSafetyAndSecurityAmenities(List<String> safetyAndSecurityAmenities) {
        this.safetyAndSecurityAmenities = safetyAndSecurityAmenities;
    }

    public List<String> getRoomAccessibilityAmenities() {
        return roomAccessibilityAmenities;
    }

    public void setRoomAccessibilityAmenities(List<String> roomAccessibilityAmenities) {
        this.roomAccessibilityAmenities = roomAccessibilityAmenities;
    }

    public List<String> getBathroomAmenities() {
        return bathroomAmenities;
    }

    public void setBathroomAmenities(List<String> bathroomAmenities) {
        this.bathroomAmenities = bathroomAmenities;
    }

    public List<String> getMediaAndTechnologyAmenities() {
        return mediaAndTechnologyAmenities;
    }

    public void setMediaAndTechnologyAmenities(List<String> mediaAndTechnologyAmenities) {
        this.mediaAndTechnologyAmenities = mediaAndTechnologyAmenities;
    }

    public List<String> getEntertainmentAndFamilyServicesAmenities() {
        return entertainmentAndFamilyServicesAmenities;
    }

    public void setEntertainmentAndFamilyServicesAmenities(List<String> entertainmentAndFamilyServicesAmenities) {
        this.entertainmentAndFamilyServicesAmenities = entertainmentAndFamilyServicesAmenities;
    }

    public List<String> getFoodAndDrinkAmenities() {
        return foodAndDrinkAmenities;
    }

    public void setFoodAndDrinkAmenities(List<String> foodAndDrinkAmenities) {
        this.foodAndDrinkAmenities = foodAndDrinkAmenities;
    }

    public List<String> getRoomAmenities() {
        return roomAmenities;
    }

    public void setRoomAmenities(List<String> roomAmenities) {
        this.roomAmenities = roomAmenities;
    }

    public List<String> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<String> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Boolean getPets() {
        return pets;
    }

    public void setPets(Boolean pets) {
        this.pets = pets;
    }

    public String getBookingCancelPeriod() {
        return bookingCancelPeriod;
    }

    public void setBookingCancelPeriod(String bookingCancelPeriod) {
        this.bookingCancelPeriod = bookingCancelPeriod;
    }

    public String getBookingCancelCharge() {
        return bookingCancelCharge;
    }

    public void setBookingCancelCharge(String bookingCancelCharge) {
        this.bookingCancelCharge = bookingCancelCharge;
    }


    public String getPetsCharge() {
        return petsCharge;
    }

    public void setPetsCharge(String petsCharge) {
        this.petsCharge = petsCharge;
    }

    public LocalTime getCheckInTimeFrom() {
        return checkInTimeFrom;
    }

    public void setCheckInTimeFrom(LocalTime checkInTimeFrom) {
        this.checkInTimeFrom = checkInTimeFrom;
    }

    public LocalTime getCheckInTimeTo() {
        return checkInTimeTo;
    }

    public void setCheckInTimeTo(LocalTime checkInTimeTo) {
        this.checkInTimeTo = checkInTimeTo;
    }

    public LocalTime getCheckOutTimeFrom() {
        return checkOutTimeFrom;
    }

    public void setCheckOutTimeFrom(LocalTime checkOutTimeFrom) {
        this.checkOutTimeFrom = checkOutTimeFrom;
    }

    public LocalTime getCheckOutTimeTo() {
        return checkOutTimeTo;
    }

    public void setCheckOutTimeTo(LocalTime checkOutTimeTo) {
        this.checkOutTimeTo = checkOutTimeTo;
    }

    public List<AddOnDTO> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<AddOnDTO> addOns) {
        this.addOns = addOns;
    }


    public List<NewHotelRoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<NewHotelRoomDTO> roomList) {
        this.rooms = roomList;
    }


    public List<String> getOtherAmenities() {
        return otherAmenities;
    }

    public void setOtherAmenities(List<String> otherAmenities) {
        this.otherAmenities = otherAmenities;
    }

    public List<String> getMostCommonAmenities() {
        return mostCommonAmenities;
    }

    public void setMostCommonAmenities(List<String> mostCommonAmenities) {
        this.mostCommonAmenities = mostCommonAmenities;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<String> getContactNumbers() {
        return contactNumbers;
    }


    public void setContactNumbers(List<String> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
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


}


