package com.hotel.demo.service;

import com.hotel.demo.model.DTO.RoomDTO;
import com.hotel.demo.model.DTO.RoomResponse;

import java.util.List;

public interface RoomService {

    List<RoomResponse> findAllRooms();

    RoomResponse findRoomById(Long id);

    RoomResponse createRoom(RoomDTO roomDTO);

    void updateRoom(Long id, RoomDTO roomDTO);

    void deleteRoom(Long id);
}
