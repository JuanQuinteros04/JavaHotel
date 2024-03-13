package com.hotel.demo.services;

import com.hotel.demo.models.DTO.ClientDTO;
import com.hotel.demo.models.DTO.ClientResponse;

import java.util.List;

public interface ClientService {
    List<ClientResponse> findAllClients();

    ClientResponse findClientById(Long id);

    ClientResponse createClient(ClientDTO clientDTO);

    void updateClient(Long id, ClientDTO clientDTO);

    void deleteClient(Long id);
}
