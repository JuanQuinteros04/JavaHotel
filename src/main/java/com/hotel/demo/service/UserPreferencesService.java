package com.hotel.demo.service;

import com.hotel.demo.model.DTO.UserPreferenceResponse;
import com.hotel.demo.model.DTO.UserPreferencesDTO;

import java.util.List;

public interface UserPreferencesService {

    List<UserPreferenceResponse> findAllUserPreferences();

    UserPreferenceResponse findUserPreferencesById(Long id);

    UserPreferenceResponse createUserPreferences(UserPreferencesDTO userPreferencesDTO);

    void updateUserPreferences(Long id, UserPreferencesDTO userPreferencesDTO);

    void deleteUserPreferences(Long id);
}
