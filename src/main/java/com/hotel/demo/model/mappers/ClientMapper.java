package com.hotel.demo.model.mappers;

import com.hotel.demo.model.Client;
import com.hotel.demo.model.DTO.ClientDTO;
import com.hotel.demo.model.DTO.ClientResponse;
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
