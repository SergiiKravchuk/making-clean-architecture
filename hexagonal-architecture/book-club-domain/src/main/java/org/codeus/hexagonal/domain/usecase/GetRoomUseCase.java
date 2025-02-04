package org.codeus.hexagonal.domain.usecase;

import java.util.Optional;
import java.util.Set;

public interface GetRoomUseCase {

  record Request(Long roomId) {
  }

  record Response(Long roomId, String roomName, Long ownerId, Set<Long> clubberIds, String bookIsbn) {
  }

  Optional<Response> getRoom(Request request);
}