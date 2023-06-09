package com.example.relaxwikiapi.service.hotel;

import com.example.relaxwikiapi.dto.hotel.*;
import com.example.relaxwikiapi.entity.hotel.*;
import com.example.relaxwikiapi.exception.AppsException;
import com.example.relaxwikiapi.repository.hotel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TKHotelServiceImpl implements TKHotelService {

    @Autowired
    private TKHotelJDBCRepository tkHotelJDBCRepository;

    @Autowired
    private TKHotelRepository tkHotelRepository;

    @Autowired
    private TKHotelReviewRepository tkHotelReviewRepository;

    @Autowired
    private TKHotelImageRepository tkHotelImageRepository;

    @Autowired
    private TKHotelRoomTypeRepository tkHotelRoomTypeRepository;

    @Autowired
    private TKHotelRoomTypeFacilityRepository tkHotelRoomTypeFacilityRepository;

    @Autowired
    private TKHotelBookingRepository tkHotelBookingRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<TKHotelDTO> searchHotels(TKHotelSearchRQ searchRQ) throws AppsException {
        List<TKHotelDTO> hotelDTOList = this.tkHotelJDBCRepository.searchHotels(searchRQ);

        for (TKHotelDTO hotelDTO : hotelDTOList) {
            TKHotel hotel = this.tkHotelRepository.getReferenceById(hotelDTO.getHotelID());
            for (TKHotelReview hotelReview : this.tkHotelReviewRepository.findByTkHotel(hotel)) {
                hotelDTO.getHotelReviewList().add(new TKHotelReviewDTO(hotelReview));
            }
            for (TKHotelImage hotelImage : this.tkHotelImageRepository.findAllByTkHotel(hotel)) {
                hotelDTO.getHotelImageList().add(new TKHotelImageDTO(hotelImage));
            }
        }

        return hotelDTOList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TKHotelDTO findHotelByID(Long hotelID) throws AppsException {
        TKHotel hotel = this.tkHotelRepository.getReferenceById(hotelID);
        TKHotelDTO hotelDTO = new TKHotelDTO(hotel);

        for (TKHotelReview hotelReview : this.tkHotelReviewRepository.findByTkHotel(hotel)) {
            hotelDTO.getHotelReviewList().add(new TKHotelReviewDTO(hotelReview));
        }

        for (TKHotelImage hotelImage : this.tkHotelImageRepository.findAllByTkHotel(hotel)) {
            hotelDTO.getHotelImageList().add(new TKHotelImageDTO(hotelImage));
        }

        for (TKHotelRoomType hotelRoomType : this.tkHotelRoomTypeRepository.findAllByTkHotel(hotel)) {
            TKHotelRoomTypeDTO hotelRoomTypeDTO = new TKHotelRoomTypeDTO(hotelRoomType);

            for (TKHotelRoomTypeFacility hotelRoomTypeFacility : this.tkHotelRoomTypeFacilityRepository.findAllByTkHotelRoomType(hotelRoomType)) {
                hotelRoomTypeDTO.getHotelRoomTypeFacilities().add(new TKHotelRoomTypeFacilityDTO(hotelRoomTypeFacility));
            }

            hotelDTO.getHotelRoomTypeList().add(hotelRoomTypeDTO);
        }

        return hotelDTO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public TKHotelBookingDTO hotelBooking(TKHotelBookingDTO bookingDTO) throws AppsException {
        TKHotelBooking hotelBooking = new TKHotelBooking();

        hotelBooking.setHotelID(bookingDTO.getHotelID());
        hotelBooking.setHotelRoomTypeID(bookingDTO.getHotelRoomTypeID());
        hotelBooking.setFirstName(bookingDTO.getFirstName());
        hotelBooking.setLastName(bookingDTO.getLastName());
        hotelBooking.setEmail(bookingDTO.getEmail());
        hotelBooking.setSpecialRequests(bookingDTO.getSpecialRequests());
        hotelBooking.setArrivalTime(bookingDTO.getArrivalTime());
        hotelBooking.setBookingDate(bookingDTO.getBookingDate());

        hotelBooking = this.tkHotelBookingRepository.saveAndFlush(hotelBooking);

        return new TKHotelBookingDTO(hotelBooking);
    }
}
