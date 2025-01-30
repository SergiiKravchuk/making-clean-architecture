package org.codeus.three_layered_arch.service;

import org.codeus.three_layered_arch.dto.RoomDto;
import org.codeus.three_layered_arch.dto.RoomView;

import java.util.List;
import java.util.Optional;

public interface RoomService {

  Long createRoom(RoomDto roomDto);

  Optional<RoomView> getRoomById(Long id);

  List<RoomView> getAllRooms();
}
