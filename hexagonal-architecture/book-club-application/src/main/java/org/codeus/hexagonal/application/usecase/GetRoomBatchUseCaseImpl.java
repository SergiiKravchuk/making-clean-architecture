package org.codeus.hexagonal.application.usecase;

import org.codeus.hexagonal.domain.repository.RoomRepository;
import org.codeus.hexagonal.domain.usecase.GetRoomBatchUseCase;

import java.util.List;

public class GetRoomBatchUseCaseImpl implements GetRoomBatchUseCase {

  private final RoomRepository repository;

  public GetRoomBatchUseCaseImpl(RoomRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Response> getAllRooms(Request request) {
    return repository.getAllRooms().stream().map(this::mapResponse).toList();
  }

  protected Response mapResponse(RoomRepository.DbRoom room) {
    return new Response(
      room.id(),
      room.name(),
      room.ownerId(),
      room.clubberIds(),
      room.bookId());
  }
}
