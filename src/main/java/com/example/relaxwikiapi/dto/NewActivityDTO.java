package com.example.relaxwikiapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;
import java.util.List;

public class NewActivityDTO {
    @NotEmpty
    @Size(min = 3, message = "Invalid activity center name.")
    private String activityCenterName;
    private String activityCenterDesc;
    @NotEmpty
    @Size(min = 3, message = "Invalid name")
    private String contactPersonName;
    //    @NotEmpty
    private List<String> contactNumbers;
    private String postalCode;
    @NotEmpty
    private String streetAddress;
    private String addressLine2;
    @NotEmpty
    private String city;
    @NotEmpty
    private String country;
    private List<String> transportationMethods;
    private String entertainmentCategory;
    private LocalTime openTimeFrom;
    private LocalTime openTimeTo;
    private int lowestRateForOnePerson;
    private List<String> languages;
    private String bookingCancelPeriod;
    private String bookingCancelCharge;
    private List<String> paymentMethods;
    private List<String> mealsProvided;
    private List<String> photoUrls;
    private List<String> facilities;
    private List<String>activities;
    private List<String> packages;
    private List<AddOnDTO> addOns;

    public List<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public List<String> getPackages() {
        return packages;
    }

    public void setPackages(List<String> packages) {
        this.packages = packages;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<String> getMealsProvided() {
        return mealsProvided;
    }

    public void setMealsProvided(List<String> mealsProvided) {
        this.mealsProvided = mealsProvided;
    }

    public String getActivityCenterName() {
        return activityCenterName;
    }

    public void setActivityCenterName(String activityCenterName) {
        this.activityCenterName = activityCenterName;
    }

    public String getActivityCenterDesc() {
        return activityCenterDesc;
    }

    public void setActivityCenterDesc(String activityCenterDesc) {
        this.activityCenterDesc = activityCenterDesc;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public List<String> getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(List<String> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getTransportationMethods() {
        return transportationMethods;
    }

    public void setTransportationMethods(List<String> transportationMethods) {
        this.transportationMethods = transportationMethods;
    }

    public String getEntertainmentCategory() {
        return entertainmentCategory;
    }

    public void setEntertainmentCategory(String entertainmentCategory) {
        this.entertainmentCategory = entertainmentCategory;
    }

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

    public int getLowestRateForOnePerson() {
        return lowestRateForOnePerson;
    }

    public void setLowestRateForOnePerson(int lowestRateForOnePerson) {
        this.lowestRateForOnePerson = lowestRateForOnePerson;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
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

    public List<String> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<String> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }


    public List<AddOnDTO> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<AddOnDTO> addOns) {
        this.addOns = addOns;
    }
}
