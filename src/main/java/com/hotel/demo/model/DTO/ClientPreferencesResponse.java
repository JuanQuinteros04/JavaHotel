package com.hotel.demo.model.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class ClientPreferencesResponse extends ClientPreferencesDTO{
    private Long id;

}
