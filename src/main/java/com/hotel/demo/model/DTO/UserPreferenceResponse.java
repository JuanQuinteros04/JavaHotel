package com.hotel.demo.model.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class UserPreferenceResponse extends UserPreferencesDTO{
    private Long id;

}
