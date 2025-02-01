package org.codeus.three_layered_arch.service;

import org.codeus.three_layered_arch.dto.RoomBasicData;
import org.codeus.three_layered_arch.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

  Long createRoom(RoomBasicData roomDto);

  Optional<Room> getRoomById(Long id);

  List<Room> getAllRooms();
}
