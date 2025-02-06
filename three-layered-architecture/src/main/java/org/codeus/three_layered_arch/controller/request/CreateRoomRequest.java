package org.codeus.three_layered_arch.controller.request;

import org.codeus.three_layered_arch.dto.RoomBasicData;

import java.util.Set;

public record CreateRoomRequest(String roomName, Long ownerId, Set<Long> clubberIds, String bookId) {

  public static RoomBasicData toData(CreateRoomRequest request) {
    return new RoomBasicData(request.roomName(), request.ownerId(), request.clubberIds(), request.bookId());
  }
}