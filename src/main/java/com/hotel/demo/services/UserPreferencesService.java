package com.hotel.demo.services;

import com.hotel.demo.models.DTO.UserPreferenceResponse;
import com.hotel.demo.models.DTO.UserPreferencesDTO;

import java.util.List;

public interface UserPreferencesService {

    List<UserPreferenceResponse> findAllUserPreferences();

    UserPreferenceResponse findUserPreferencesById(Long id);

    UserPreferenceResponse createUserPreference(UserPreferencesDTO userPreferencesDTO);

    void updateUserPreference(Long id, UserPreferencesDTO userPreferencesDTO);

    void deleteUserPreference(Long id);
}
