package com.hotel.demo.services;

import com.hotel.demo.exceptions.NotFoundException;
import com.hotel.demo.models.Booking;
import com.hotel.demo.models.DTO.BookingDTO;
import com.hotel.demo.models.DTO.BookingResponse;
import com.hotel.demo.models.mappers.BookingMapper;
import com.hotel.demo.persistence.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepository bookingRepository;

    BookingMapper bookingMapper = BookingMapper.INSTANCE;

    @Override
    public List<BookingResponse> findAllBookings() {
        return bookingRepository.findAll().stream().map(booking -> bookingMapper.bookingToBookingResponse(booking)).collect(Collectors.toList());
    }

    @Override
    public BookingResponse findBookingById(Long id) {
        return bookingMapper.bookingToBookingResponse(bookingRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public BookingResponse createBooking(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.bookingDTOToBooking(bookingDTO);
        bookingRepository.save(booking);
        return bookingMapper.bookingToBookingResponse(booking);
    }

    @Override
    public void updateBooking(Long id, BookingDTO bookingDTO) {
        Booking booking = bookingRepository.findById(id).orElseThrow(NotFoundException::new);

        booking.setTypeRoom(bookingDTO.getTypeRoom() != null ? bookingDTO.getTypeRoom() : booking.getTypeRoom());
        booking.setNumberPeople(bookingDTO.getNumberPeople() != null ? bookingDTO.getNumberPeople() : booking.getNumberPeople());
        booking.setPrice(bookingDTO.getPrice() != null ? bookingDTO.getPrice() : booking.getPrice());
        booking.setEntryDate(bookingDTO.getEntryDate() != null ? bookingDTO.getEntryDate() : booking.getEntryDate());
        booking.setDepartureDate(bookingDTO.getDepartureDate() != null ? bookingDTO.getDepartureDate() : booking.getDepartureDate());
    }

    @Override
    public void deleteBooking(Long id) {

        bookingRepository.delete(bookingRepository.findById(id).orElseThrow(NotFoundException::new));

    }
}
