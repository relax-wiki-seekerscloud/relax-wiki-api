package com.example.relaxwikiapi.service;

import com.example.relaxwikiapi.dto.AddOnDTO;
import com.example.relaxwikiapi.dto.HotelRoomBedDTO;
import com.example.relaxwikiapi.dto.NewHotelDTO;
import com.example.relaxwikiapi.dto.NewHotelRoomDTO;
import com.example.relaxwikiapi.entity.*;
import com.example.relaxwikiapi.repo.HotelDetailsRepository;
import com.example.relaxwikiapi.repo.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HotelDetailsServiceIMPL implements HotelDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HotelDetailsRepository hotelDetailsRepository;

    @Override
    public HotelDetails addHotelDetails(HotelDetails hotelDetails) {
        return hotelDetailsRepository.save(hotelDetails);
    }

    @Override
    public List<HotelDetails> getAllHotelDetails() {
        return hotelDetailsRepository.findAll();
    }

    @Override
    public HotelDetails getHotelDetailsById(Long id) {
        return hotelDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public HotelDetails updateName(Long id, String name) {
        HotelDetails hotelDetails = hotelDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel details not found"));
        hotelDetails.setName(name);
        return hotelDetailsRepository.save(hotelDetails);
    }

    @Override
    public HotelDetails updateAddress(Long id, String address) {
        HotelDetails hotelDetails = hotelDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel details not found"));
        hotelDetails.setAddress(address);
        return hotelDetailsRepository.save(hotelDetails);
    }

    @Override
    public HotelDetails updateDescription(Long id, String description) {
        HotelDetails hotelDetails = hotelDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel details not found"));
        hotelDetails.setDescription(description);
        return hotelDetailsRepository.save(hotelDetails);
    }

    @Override
    public HotelDetails updatePhoneNo(Long id, String phoneNo) {
        HotelDetails hotelDetails = hotelDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel details not found"));
        hotelDetails.setPhoneNo(phoneNo);
        return hotelDetailsRepository.save(hotelDetails);
    }

    @Override
    public HotelDetails updateEmail(Long id, String email) {
        HotelDetails hotelDetails = hotelDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel details not found"));
        hotelDetails.setEmail(email);
        return hotelDetailsRepository.save(hotelDetails);
    }

    @Override
    public HotelDetails updatePassword(Long id, String password) {
        HotelDetails hotelDetails = hotelDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel details not found"));
        hotelDetails.setPassword(password);
        return hotelDetailsRepository.save(hotelDetails);
    }

    @Override
    public HotelDetails updatePhoto(Long id, byte[] photo) {
        HotelDetails hotelDetails = hotelDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel details not found"));
        hotelDetails.setPhoto(photo);
        return hotelDetailsRepository.save(hotelDetails);
    }

    @Override
    public HotelDetails updateLanguage(Long id, List<String> languages) {
        HotelDetails hotelDetails = hotelDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hotel details not found"));
        hotelDetails.setLanguages(languages);
        return hotelDetailsRepository.save(hotelDetails);
    }

    @Override
    public HotelDetails updateFacilities(Long id, List<String> facilities) {
        HotelDetails hotelDetails = hotelDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hotel details not found"));
        hotelDetails.setFacilities(facilities);
        return hotelDetailsRepository.save(hotelDetails);
    }

    @Override
    public HotelDetails updateServices(Long id, List<String> services) {
        HotelDetails hotelDetails = hotelDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hotel details not found"));
        hotelDetails.setServices(services);
        return hotelDetailsRepository.save(hotelDetails);
    }

    @Override
    public HotelDetails updateMostCommonAmenities(Long id, List<String> mostCommonAmenities) {
        HotelDetails hotelDetails = hotelDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hotel details not found"));
        hotelDetails.setMostCommonAmenities(mostCommonAmenities);
        return hotelDetailsRepository.save(hotelDetails);
    }

    @Override
    public HotelDetails updateOtherAmenities(Long id, List<String> otherAmenities) {
        HotelDetails hotelDetails = hotelDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hotel details not found"));
        hotelDetails.setOtherAmenities(otherAmenities);
        return hotelDetailsRepository.save(hotelDetails);
    }

    @Override
    public String addNewHotel(NewHotelDTO newHotelDTO, User user) {
        HotelDetails hotel = new HotelDetails();
        hotel.setName(newHotelDTO.getHotelName());
        hotel.setStarRating(newHotelDTO.getStarRating());
        hotel.setContactPersonName(newHotelDTO.getContactPersonName());
        hotel.setAddress(newHotelDTO.getPostalCode() + ", " + newHotelDTO.getStreetAddress() + ", " + newHotelDTO.getAddressLine2() + ", " + newHotelDTO.getCity() + ", " + newHotelDTO.getCountry());
        hotel.setContactNumbers(newHotelDTO.getContactNumbers());
        hotel.setPhotoUrls(newHotelDTO.getPhotoUrls());
        hotel.setLanguages(newHotelDTO.getLanguages());
        hotel.setPaymentMethods(newHotelDTO.getPaymentMethods());
        hotel.setBookingCancelPeriod(newHotelDTO.getBookingCancelPeriod());
        hotel.setBookingCancelCharge(newHotelDTO.getBookingCancelCharge());
        hotel.setPets(newHotelDTO.getPets());
        hotel.setPetsCharge(newHotelDTO.getPetsCharge());
        hotel.setCheckInTimeFrom(newHotelDTO.getCheckInTimeFrom());
        hotel.setCheckInTimeTo(newHotelDTO.getCheckInTimeTo());
        hotel.setCheckOutTimeFrom(newHotelDTO.getCheckOutTimeFrom());
        hotel.setCheckOutTimeTo(newHotelDTO.getCheckOutTimeTo());
        hotel.setUser(user);
        if (newHotelDTO.getRooms() != null) {
            for (NewHotelRoomDTO hotelRoomDto : newHotelDTO.getRooms()) {
                HotelRoom hotelRoom = new HotelRoom();
                hotelRoom.setRoomType(hotelRoomDto.getRoomType());
                hotelRoom.setRoomName(hotelRoomDto.getRoomName());
                hotelRoom.setRoomSize(hotelRoomDto.getRoomSize());
                hotelRoom.setCustomRoomName(hotelRoomDto.getCustomRoomName());
                hotelRoom.setNoOfPeople(hotelRoomDto.getNoOfPeople());
                hotelRoom.setRoomCountFromRoomType(hotelRoomDto.getRoomCountFromRoomType());
                hotelRoom.setSmokingPolicy(hotelRoomDto.getSmokingPolicy());
                hotelRoom.setBathroomCount(hotelRoomDto.getBathroomCount());
                hotelRoom.setLivingRoomCount(hotelRoomDto.getLivingRoomCount());
                hotelRoom.setBedroomCount(hotelRoomDto.getBedroomCount());
                hotelRoom.setPricePerNight(hotelRoomDto.getPricePerNight());
                if (hotelRoomDto.getBeds() != null) {
                    for (HotelRoomBedDTO newBed : hotelRoomDto.getBeds()) {
                        HotelRoomBed bed = new HotelRoomBed();
                        bed.setBedType(newBed.getBedType());
                        hotelRoom.addBed(bed);
                    }
                }
                hotel.addRoom(hotelRoom);
            }
        }

//        if (newHotelDTO.getAddOns() != null) {
//            for (AddOnDTO addOnDTO : newHotelDTO.getAddOns()) {
//                AddOn addOn = new AddOn();
//                addOn.setType(addOnDTO.getType());
//                addOn.setName(addOnDTO.getName());
//                addOn.setCategory(addOnDTO.getCategory());
//                hotel.addAddOn(addOn);
//            }
//        }
        if (newHotelDTO.getMostCommonAmenities() != null) {
            for (String amenity : newHotelDTO.getMostCommonAmenities()) {
                AddOn addOn = new AddOn();
                addOn.setCategory("Amenity");
                addOn.setSubCategory("Most Common Amenity");
                addOn.setName(amenity);
                hotel.addAddOn(addOn);
            }
        }

        if (newHotelDTO.getRoomAmenities() != null) {
            for (String amenity : newHotelDTO.getRoomAmenities()) {
                AddOn addOn = new AddOn();
                addOn.setCategory("Amenity");
                addOn.setSubCategory("Room Amenity");
                addOn.setName(amenity);
                hotel.addAddOn(addOn);
            }
        }

        if (newHotelDTO.getFoodAndDrinkAmenities() != null) {
            for (String amenity : newHotelDTO.getFoodAndDrinkAmenities()) {
                AddOn addOn = new AddOn();
                addOn.setCategory("Amenity");
                addOn.setSubCategory("Food and Drink Amenity");
                addOn.setName(amenity);
                hotel.addAddOn(addOn);
            }
        }

        if (newHotelDTO.getEntertainmentAndFamilyServicesAmenities() != null) {
            for (String amenity : newHotelDTO.getEntertainmentAndFamilyServicesAmenities()) {
                AddOn addOn = new AddOn();
                addOn.setCategory("Amenity");
                addOn.setSubCategory("Entertainment and Family Services Amenity");
                addOn.setName(amenity);
                hotel.addAddOn(addOn);
            }
        }

        if (newHotelDTO.getMediaAndTechnologyAmenities() != null) {
            for (String amenity : newHotelDTO.getMediaAndTechnologyAmenities()) {
                AddOn addOn = new AddOn();
                addOn.setCategory("Amenity");
                addOn.setSubCategory("Media and Technology Amenity");
                addOn.setName(amenity);
                hotel.addAddOn(addOn);
            }
        }

        if (newHotelDTO.getBathroomAmenities() != null) {
            for (String amenity : newHotelDTO.getBathroomAmenities()) {
                AddOn addOn = new AddOn();
                addOn.setCategory("Amenity");
                addOn.setSubCategory("Bathroom Amenity");
                addOn.setName(amenity);
                hotel.addAddOn(addOn);
            }
        }

        if (newHotelDTO.getRoomAccessibilityAmenities() != null) {
            for (String amenity : newHotelDTO.getRoomAccessibilityAmenities()) {
                AddOn addOn = new AddOn();
                addOn.setCategory("Amenity");
                addOn.setSubCategory("Room Accessibility Amenity");
                addOn.setName(amenity);
                hotel.addAddOn(addOn);
            }
        }

        if (newHotelDTO.getSafetyAndSecurityAmenities()!=null){
            for (String amenity:newHotelDTO.getSafetyAndSecurityAmenities()){
                AddOn addOn=new AddOn();
                addOn.setCategory("Amenity");
                addOn.setSubCategory("Safety and Security");
                addOn.setName(amenity);
                hotel.addAddOn(addOn);
            }
        }

        if (newHotelDTO.getOutdoorAmenities()!=null){
            for (String amenity:newHotelDTO.getOutdoorAmenities()){
                AddOn addOn=new AddOn();
                addOn.setCategory("Amenity");
                addOn.setSubCategory("Outdoor Amenity");
                addOn.setName(amenity);
                hotel.addAddOn(addOn);
            }
        }

        if (newHotelDTO.getServicesAndExtraAmenities()!=null){
            for (String amenity:newHotelDTO.getServicesAndExtraAmenities()){
                AddOn addOn=new AddOn();
                addOn.setCategory("amenity");
                addOn.setSubCategory("Services and Extra Amenity");
                addOn.setName(amenity);
                hotel.addAddOn(addOn);
            }
        }

        if (newHotelDTO.getFacilities()!=null){
            for (String facility:newHotelDTO.getFacilities()){
                AddOn addOn=new AddOn();
                addOn.setCategory("facility");
                addOn.setSubCategory("");
                addOn.setName(facility);
                hotel.addAddOn(addOn);
            }
        }

        if (newHotelDTO.getServices()!=null){
            for (String service:newHotelDTO.getServices()){
                AddOn addOn=new AddOn();
                addOn.setCategory("service");
                addOn.setName(service);
                hotel.addAddOn(addOn);
            }
        }

        try {
            hotelDetailsRepository.save(hotel);
        } catch (Exception e) {
            System.out.println(e);
            return "Error";
        }
        return "Success";
    }
}