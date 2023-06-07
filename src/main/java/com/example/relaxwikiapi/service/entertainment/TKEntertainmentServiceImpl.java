package com.example.relaxwikiapi.service.entertainment;

import com.example.relaxwikiapi.dto.entertainment.TKEntertainmentBookingDTO;
import com.example.relaxwikiapi.dto.entertainment.TKEntertainmentDTO;
import com.example.relaxwikiapi.dto.entertainment.TKEntertainmentImageDTO;
import com.example.relaxwikiapi.dto.entertainment.TKEntertainmentSearchRQ;
import com.example.relaxwikiapi.entity.entertainment.TKEntertainment;
import com.example.relaxwikiapi.entity.entertainment.TKEntertainmentBooking;
import com.example.relaxwikiapi.entity.entertainment.TKEntertainmentImage;
import com.example.relaxwikiapi.entity.hotel.TKHotelBooking;
import com.example.relaxwikiapi.exception.AppsException;
import com.example.relaxwikiapi.repository.entertainment.TKEntertainmentBookingRepository;
import com.example.relaxwikiapi.repository.entertainment.TKEntertainmentImageRepository;
import com.example.relaxwikiapi.repository.entertainment.TKEntertainmentJDBCRepository;
import com.example.relaxwikiapi.repository.entertainment.TKEntertainmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TKEntertainmentServiceImpl implements TKEntertainmentService {

    @Autowired
    private TKEntertainmentRepository tkEntertainmentRepository;

    @Autowired
    private TKEntertainmentJDBCRepository tkEntertainmentJDBCRepository;

    @Autowired
    private TKEntertainmentImageRepository tkEntertainmentImageRepository;

    @Autowired
    private TKEntertainmentBookingRepository tkEntertainmentBookingRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<TKEntertainmentDTO> searchEntertainments(TKEntertainmentSearchRQ searchRQ) throws AppsException {
        List<TKEntertainmentDTO> entertainmentDTOList = this.tkEntertainmentJDBCRepository.searchEntertainments(searchRQ);

        for (TKEntertainmentDTO tkEntertainmentDTO : entertainmentDTOList) {
            TKEntertainment tkEntertainment = this.tkEntertainmentRepository.getReferenceById(tkEntertainmentDTO.getEntertainmentID());

            for (TKEntertainmentImage entertainmentImage : this.tkEntertainmentImageRepository.findAllByTkEntertainment(tkEntertainment)) {
                tkEntertainmentDTO.getEntertainmentImageDTOList().add(new TKEntertainmentImageDTO(entertainmentImage));
            }
        }

        return entertainmentDTOList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TKEntertainmentDTO findEntertainmentByID(Long entertainmentID) throws AppsException {
        TKEntertainment tkEntertainment = this.tkEntertainmentRepository.getReferenceById(entertainmentID);
        TKEntertainmentDTO tkEntertainmentDTO = new TKEntertainmentDTO(tkEntertainment);

        for (TKEntertainmentImage entertainmentImage : this.tkEntertainmentImageRepository.findAllByTkEntertainment(tkEntertainment)) {
            tkEntertainmentDTO.getEntertainmentImageDTOList().add(new TKEntertainmentImageDTO(entertainmentImage));
        }

        return tkEntertainmentDTO;
    }

    @Override
    public TKEntertainmentBookingDTO entertainmentBooking(TKEntertainmentBookingDTO bookingDTO) {
        TKEntertainmentBooking entertainmentBooking = new TKEntertainmentBooking();

        entertainmentBooking.setEntertainmentID(bookingDTO.getEntertainmentID());
        entertainmentBooking.setFirstName(bookingDTO.getFirstName());
        entertainmentBooking.setLastName(bookingDTO.getLastName());
        entertainmentBooking.setEmail(bookingDTO.getEmail());
        entertainmentBooking.setSpecialRequests(bookingDTO.getSpecialRequests());
        entertainmentBooking.setArrivalTime(bookingDTO.getArrivalTime());
        entertainmentBooking.setBookingDate(bookingDTO.getBookingDate());

        entertainmentBooking = this.tkEntertainmentBookingRepository.saveAndFlush(entertainmentBooking);

        return new TKEntertainmentBookingDTO(entertainmentBooking);
    }
}
