package org.codeus.hexagonal.domain.usecase;

import java.util.List;
import java.util.Set;

public interface GetRoomBatchUseCase {

  record Request() {
  }

  record Response(Long roomId, String roomName, Long ownerId, Set<Long> clubberIds, String bookIsbn) {
  }

  List<Response> getAllRooms(Request request);
}