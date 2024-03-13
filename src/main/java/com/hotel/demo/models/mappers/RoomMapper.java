package com.hotel.demo.models.mappers;

import com.hotel.demo.models.DTO.RoomDTO;
import com.hotel.demo.models.DTO.RoomResponse;
import com.hotel.demo.models.Room;
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
