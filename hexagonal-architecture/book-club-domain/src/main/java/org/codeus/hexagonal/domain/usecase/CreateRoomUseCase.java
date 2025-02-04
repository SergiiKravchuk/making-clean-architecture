package org.codeus.hexagonal.domain.usecase;

import java.util.Set;

public interface CreateRoomUseCase {

  record Request(String roomName, Long ownerId, Set<Long> clubberIds, String bookIsbn) {
  }

  record Response(Long roomId) {
  }

  Response createRoom(Request request);

}
