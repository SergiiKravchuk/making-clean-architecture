package org.codeus.hexagonal.domain.usecase;

import java.util.List;
import java.util.Set;

public interface GetRoomBatchUseCase {

  record Request() {
  }

  record RoomView(Long roomId, String roomName, Long ownerId, Set<Long> clubberIds, String bookIsbn) {
  }

  record Response(List<RoomView> roomViews) {
  }

  Response getAllRooms(Request request);
}