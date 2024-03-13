package com.hotel.demo.models.mappers;

import com.hotel.demo.models.DTO.UserPreferenceResponse;
import com.hotel.demo.models.DTO.UserPreferencesDTO;
import com.hotel.demo.models.UserPreferences;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserPreferencesMapper {

    UserPreferencesMapper INSTANCE = Mappers.getMapper(UserPreferencesMapper.class);

    @Mapping(target = "id", ignore = true)
    UserPreferences userPreferencesDTOToUserPreferences(UserPreferencesDTO userPreferencesDTO);

    UserPreferenceResponse userPreferencesToUserPreferencesResponse(UserPreferences userPreferences);
}
