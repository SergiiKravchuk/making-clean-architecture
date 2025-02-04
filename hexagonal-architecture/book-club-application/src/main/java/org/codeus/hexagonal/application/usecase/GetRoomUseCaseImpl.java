package org.codeus.hexagonal.application.usecase;

import org.codeus.hexagonal.domain.repository.RoomRepository;
import org.codeus.hexagonal.domain.usecase.GetRoomUseCase;

import java.util.Optional;

public class GetRoomUseCaseImpl implements GetRoomUseCase {

  private final RoomRepository repository;

  public GetRoomUseCaseImpl(RoomRepository repository) {
    this.repository = repository;
  }

  @Override
  // as getRoomById
  public Optional<Response> getRoom(Request request) {
    return repository.getRoomById(request.roomId()).map(dbRoom ->
      new Response(
        dbRoom.id(),
        dbRoom.name(),
        dbRoom.ownerId(),
        dbRoom.clubberIds(),
        dbRoom.bookId()
      ));
  }
}
