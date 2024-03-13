package com.hotel.demo.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private String typeRoom;

    private Long roomCapacity;

    private Boolean availableRoom;

    private Double price;

}
