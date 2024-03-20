package com.hotel.demo.model.mappers;

import com.hotel.demo.model.Booking;
import com.hotel.demo.model.DTO.BookingDTO;
import com.hotel.demo.model.DTO.BookingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingMapper {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(target = "id", ignore = true)
    Booking bookingDTOToBooking(BookingDTO bookingDTO);

    BookingResponse bookingToBookingResponse (Booking booking);


}
