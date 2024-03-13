package com.hotel.demo.models.mappers;

import com.hotel.demo.models.Booking;
import com.hotel.demo.models.DTO.BookingDTO;
import com.hotel.demo.models.DTO.BookingResponse;
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
