package com.hotel.demo.services;

import com.hotel.demo.models.DTO.RoomDTO;
import com.hotel.demo.models.DTO.RoomResponse;

import java.util.List;

public interface RoomService {

    List<RoomResponse> findAllRooms();

    RoomResponse findRoomById(Long id);

    RoomResponse createRoom(RoomDTO roomDTO);

    void updateRoom(Long id, RoomDTO roomDTO);

    void deleteRoom(Long id);
}
