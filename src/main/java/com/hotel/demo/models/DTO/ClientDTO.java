package com.hotel.demo.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String name;

    private String lastName;

    private String mail;

    private Long phoneNumber;


}
