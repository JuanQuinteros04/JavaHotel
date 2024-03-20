package com.hotel.demo.model.mappers;

import com.hotel.demo.model.DTO.UserPreferenceResponse;
import com.hotel.demo.model.DTO.UserPreferencesDTO;
import com.hotel.demo.model.UserPreferences;
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
