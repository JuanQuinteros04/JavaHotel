package com.hotel.demo.services;

import com.hotel.demo.exceptions.NotFoundException;
import com.hotel.demo.models.Client;
import com.hotel.demo.models.DTO.ClientDTO;
import com.hotel.demo.models.DTO.ClientResponse;
import com.hotel.demo.models.mappers.ClientMapper;
import com.hotel.demo.persistence.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    ClientMapper clientMapper = ClientMapper.INSTANCE;

    @Override
    public List<ClientResponse> findAllClients() {
        return clientRepository.findAll().stream().map(client -> clientMapper.clientToClientResponse(client)).collect(Collectors.toList());
    }

    @Override
    public ClientResponse findClientById(Long id) {
        return clientMapper.clientToClientResponse(clientRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public ClientResponse createClient(ClientDTO clientDTO) {

        Client client = clientMapper.clientDTOToClient(clientDTO);
        clientRepository.save(client);
        return clientMapper.clientToClientResponse(client);
    }

    @Override
    public void updateClient(Long id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id).orElseThrow(NotFoundException::new);

        client.setName(clientDTO.getName() != null ? clientDTO.getName() : client.getName());
        client.setLastName(clientDTO.getLastName() != null ? clientDTO.getLastName() : client.getLastName());
        client.setMail(clientDTO.getMail() != null ? clientDTO.getMail() : client.getMail());
        client.setPhoneNumber(clientDTO.getPhoneNumber() != null ? clientDTO.getPhoneNumber() : client.getPhoneNumber());

        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.delete(clientRepository.findById(id).orElseThrow(NotFoundException::new));
    }
}
