package com.hotel.demo.services;

import com.hotel.demo.exceptions.NotFoundException;
import com.hotel.demo.models.DTO.UserPreferenceResponse;
import com.hotel.demo.models.DTO.UserPreferencesDTO;
import com.hotel.demo.models.UserPreferences;
import com.hotel.demo.models.mappers.UserPreferencesMapper;
import com.hotel.demo.persistence.UserPreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserPreferenceServiceImpl implements UserPreferencesService{

    @Autowired
    UserPreferencesRepository userPreferencesRepository;

    UserPreferencesMapper userPreferencesMapper = UserPreferencesMapper.INSTANCE;

    @Override
    public List<UserPreferenceResponse> findAllUserPreferences() {
        return userPreferencesRepository.findAll().stream().map(userPreferences -> userPreferencesMapper.userPreferencesToUserPreferencesResponse(userPreferences)).collect(Collectors.toList());
    }

    @Override
    public UserPreferenceResponse findUserPreferencesById(Long id) {
        return userPreferencesMapper.userPreferencesToUserPreferencesResponse(userPreferencesRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public UserPreferenceResponse createUserPreferences(UserPreferencesDTO userPreferencesDTO) {
        UserPreferences userPreferences = userPreferencesMapper.userPreferencesDTOToUserPreferences(userPreferencesDTO);
        userPreferencesRepository.save(userPreferences);
        return userPreferencesMapper.userPreferencesToUserPreferencesResponse(userPreferences);
    }

    @Override
    public void updateUserPreferences(Long id, UserPreferencesDTO userPreferencesDTO) {
        UserPreferences userPreferences = userPreferencesRepository.findById(id).orElseThrow(NotFoundException::new);

        userPreferences.setUserId(userPreferencesDTO.getUserId() != null ? userPreferencesDTO.getUserId() : userPreferences.getUserId());
        userPreferences.setTypeRoom(userPreferencesDTO.getTypeRoom() != null ? userPreferencesDTO.getTypeRoom() : userPreferences.getTypeRoom());
        userPreferences.setNumberPeople(userPreferencesDTO.getNumberPeople() != null ? userPreferencesDTO.getNumberPeople() : userPreferences.getNumberPeople());
        userPreferences.setPrice(userPreferencesDTO.getPrice() != null ? userPreferencesDTO.getPrice() : userPreferences.getPrice());

        userPreferencesRepository.save(userPreferences);
    }

    @Override
    public void deleteUserPreferences(Long id) {
        userPreferencesRepository.delete(userPreferencesRepository.findById(id).orElseThrow(NotFoundException::new));
    }
}
