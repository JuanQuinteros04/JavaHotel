package com.hotel.demo.controller;

import com.hotel.demo.model.DTO.UserPreferenceResponse;
import com.hotel.demo.model.DTO.UserPreferencesDTO;
import com.hotel.demo.service.UserPreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user/preferences")
public class UserPreferencesController {

    @Autowired
    UserPreferencesService userPreferencesService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserPreferenceResponse>> findAllUserPreferences(){
        return ResponseEntity.ok(userPreferencesService.findAllUserPreferences());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserPreferenceResponse>findUserPreferencesById(@PathVariable("id")Long id){
        return ResponseEntity.ok(userPreferencesService.findUserPreferencesById(id));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserPreferenceResponse>createUserPreferences(@RequestBody UserPreferencesDTO userPreferencesDTO){
        UserPreferenceResponse userPreferenceResponse = userPreferencesService.createUserPreferences(userPreferencesDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand((userPreferenceResponse.getId()))
                .toUri();

        return ResponseEntity.created(location).body(userPreferenceResponse);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateUserPreferences(@PathVariable("id")Long id, @RequestBody UserPreferencesDTO userPreferencesDTO){
        userPreferencesService.updateUserPreferences(id, userPreferencesDTO);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>deleteUserPreferences(@PathVariable("id") Long id){
        userPreferencesService.deleteUserPreferences(id);
        return ResponseEntity.status(204).build();
    }

}
