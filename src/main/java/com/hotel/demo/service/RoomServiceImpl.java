package com.hotel.demo.service;

import com.hotel.demo.exceptions.NotFoundException;
import com.hotel.demo.model.DTO.RoomDTO;
import com.hotel.demo.model.DTO.RoomResponse;
import com.hotel.demo.model.Room;
import com.hotel.demo.model.mappers.RoomMapper;
import com.hotel.demo.persistence.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    RoomRepository roomRepository;

    RoomMapper roomMapper = RoomMapper.INSTANCE;

    @Override
    public List<RoomResponse> findAllRooms() {
        return roomRepository.findAll().stream().map(room -> roomMapper.roomToRoomResponse(room)).collect(Collectors.toList());
    }

    @Override
    public RoomResponse findRoomById(Long id) {
        return roomMapper.roomToRoomResponse(roomRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public RoomResponse createRoom(RoomDTO roomDTO) {

        Room room = roomMapper.roomDTOToRoom(roomDTO);
        roomRepository.save(room);
        return roomMapper.roomToRoomResponse(room);
    }

    @Override
    public void updateRoom(Long id, RoomDTO roomDTO) {

        Room room = roomRepository.findById(id).orElseThrow(NotFoundException::new);

        room.setRoomNumber(roomDTO.getRoomNumber() != null ? roomDTO.getRoomNumber() : room.getRoomNumber());
        room.setTypeRoom(roomDTO.getTypeRoom() != null ? roomDTO.getTypeRoom() : room.getTypeRoom());
        room.setRoomCapacity(roomDTO.getRoomCapacity() != null ? roomDTO.getRoomCapacity() : room.getRoomCapacity());
        room.setAvailableRoom(roomDTO.getAvailableRoom() != null ? roomDTO.getAvailableRoom() : room.getAvailableRoom());
        room.setPrice(roomDTO.getPrice() != null ? roomDTO.getPrice() : room.getPrice());

        roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.delete(roomRepository.findById(id).orElseThrow(NotFoundException::new));
    }
}
