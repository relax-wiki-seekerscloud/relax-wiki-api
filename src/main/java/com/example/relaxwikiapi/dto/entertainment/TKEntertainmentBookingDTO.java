package com.example.relaxwikiapi.dto.entertainment;

import com.example.relaxwikiapi.entity.entertainment.TKEntertainmentBooking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKEntertainmentBookingDTO {

    private Long entertainmentBookingID;

    private String firstName;

    private String lastName;

    private String email;

    private String specialRequests;

    private String bookingDate;

    private String arrivalTime;

    private Long entertainmentID;

    public TKEntertainmentBookingDTO(TKEntertainmentBooking booking) {
        this.entertainmentBookingID = booking.getEntertainmentBookingID();
        this.firstName = booking.getFirstName();
        this.lastName = booking.getLastName();
        this.email = booking.getEmail();
        this.specialRequests = booking.getSpecialRequests();
        this.bookingDate = booking.getBookingDate();
        this.arrivalTime = booking.getArrivalTime();
        this.entertainmentID = booking.getEntertainmentID();
    }
}
