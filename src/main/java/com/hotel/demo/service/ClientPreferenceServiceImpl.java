package com.hotel.demo.service;

import com.hotel.demo.exceptions.NotFoundException;
import com.hotel.demo.model.ClientPreferences;
import com.hotel.demo.model.DTO.ClientPreferencesResponse;
import com.hotel.demo.model.DTO.ClientPreferencesDTO;
import com.hotel.demo.model.mappers.ClientPreferencesMapper;
import com.hotel.demo.persistence.ClientPreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientPreferenceServiceImpl implements ClientPreferencesService {

    @Autowired
    ClientPreferencesRepository clientPreferencesRepository;

    ClientPreferencesMapper clientPreferencesMapper = ClientPreferencesMapper.INSTANCE;

    @Override
    public List<ClientPreferencesResponse> findAll() {
        return clientPreferencesRepository.findAll().stream().map(userPreferences -> clientPreferencesMapper.clientPreferencesToClientPreferencesResponse(userPreferences)).collect(Collectors.toList());
    }

    @Override
    public ClientPreferencesResponse findById(Long id) {
        return clientPreferencesMapper.clientPreferencesToClientPreferencesResponse(clientPreferencesRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public ClientPreferencesResponse createClientPreferences(ClientPreferencesDTO userPreferencesDTO) {
        ClientPreferences clientPreferences = clientPreferencesMapper.clientPreferencesDTOToClientPreferences(userPreferencesDTO);
        clientPreferencesRepository.save(clientPreferences);
        return clientPreferencesMapper.clientPreferencesToClientPreferencesResponse(clientPreferences);
    }

    @Override
    public void updateClientPreferences(Long id, ClientPreferencesDTO clientPreferencesDTO) {
        ClientPreferences clientPreferences = clientPreferencesRepository.findById(id).orElseThrow(NotFoundException::new);

        clientPreferences.setClientId(clientPreferencesDTO.getClientId() != null ? clientPreferencesDTO.getClientId() : clientPreferences.getClientId());
        clientPreferences.setTypeRoom(clientPreferencesDTO.getTypeRoom() != null ? clientPreferencesDTO.getTypeRoom() : clientPreferences.getTypeRoom());
        clientPreferences.setNumberPeople(clientPreferencesDTO.getNumberPeople() != null ? clientPreferencesDTO.getNumberPeople() : clientPreferences.getNumberPeople());
        clientPreferences.setPrice(clientPreferencesDTO.getPrice() != null ? clientPreferencesDTO.getPrice() : clientPreferences.getPrice());

        clientPreferencesRepository.save(clientPreferences);
    }

    @Override
    public void deleteClientPreferences(Long id) {
        clientPreferencesRepository.delete(clientPreferencesRepository.findById(id).orElseThrow(NotFoundException::new));
    }
}
