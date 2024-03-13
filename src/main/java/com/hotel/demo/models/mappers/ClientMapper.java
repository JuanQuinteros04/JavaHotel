package com.hotel.demo.models.mappers;

import com.hotel.demo.models.Client;
import com.hotel.demo.models.DTO.ClientDTO;
import com.hotel.demo.models.DTO.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "id", ignore = true)
    Client clientDTOToClient(ClientDTO clientDTO);

    ClientResponse clientToClientResponse(Client client);
}
