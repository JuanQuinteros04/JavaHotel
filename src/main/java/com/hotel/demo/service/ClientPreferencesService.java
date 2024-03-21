package com.hotel.demo.service;

import com.hotel.demo.model.DTO.ClientPreferencesResponse;
import com.hotel.demo.model.DTO.ClientPreferencesDTO;

import java.util.List;

public interface ClientPreferencesService {

    List<ClientPreferencesResponse> findAll();

    ClientPreferencesResponse findById(Long id);

    ClientPreferencesResponse createClientPreferences(ClientPreferencesDTO userPreferencesDTO);

    void updateClientPreferences(Long id, ClientPreferencesDTO userPreferencesDTO);

    void deleteClientPreferences(Long id);
}
