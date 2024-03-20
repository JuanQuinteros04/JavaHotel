package com.hotel.demo.model.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class ClientResponse extends ClientDTO{
    private Long id;

}
