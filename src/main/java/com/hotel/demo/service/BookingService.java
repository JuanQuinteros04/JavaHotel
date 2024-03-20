package com.hotel.demo.service;

import com.hotel.demo.model.DTO.BookingDTO;
import com.hotel.demo.model.DTO.BookingResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookingService {

    List<BookingResponse> findAll();

    BookingResponse findById(Long id);

    BookingResponse createBooking(BookingDTO bookingDTO);

    void updateBooking(Long id,BookingDTO bookingDTO);

    void deleteBooking(Long id);


}
