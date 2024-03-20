package com.hotel.demo.model.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode
public class UserPreferencesDTO {

    private Long userId;

    private String typeRoom;

    private Long numberPeople;

    private Long price;

}
