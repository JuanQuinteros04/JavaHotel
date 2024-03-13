package com.hotel.demo.services;

import com.hotel.demo.models.DTO.BookingDTO;
import com.hotel.demo.models.DTO.BookingResponse;

import java.util.List;

public interface BookingService {

    List<BookingResponse> findAllBookings();

    BookingResponse findBookingById(Long id);

    BookingResponse createBooking(BookingDTO bookingDTO);

    void updateBooking(Long id,BookingDTO bookingDTO);

    void deleteBooking(Long id);


}
