package com.hotel.demo.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    private String typeRoom;

    private Long numberPeople;

    private Long entryDate;

    private Long departureDate;

    private Long price;


}
