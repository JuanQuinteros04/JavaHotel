package com.hotel.demo.model.mappers;

import com.hotel.demo.model.DTO.RoomDTO;
import com.hotel.demo.model.DTO.RoomResponse;
import com.hotel.demo.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(target = "id", ignore = true)
    Room roomDTOToRoom(RoomDTO roomDTO);

    RoomResponse roomToRoomResponse(Room room);


}
