package com.hotel.demo.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPreferencesDTO {

    private Long userId;

    private String typeRoom;

    private Long numberPeople;

    private Long price;

}
