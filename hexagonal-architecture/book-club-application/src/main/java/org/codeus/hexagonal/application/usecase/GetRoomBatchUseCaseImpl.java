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
  public Response getAllRooms(Request request) {
    return new Response(repository.getAllRooms().stream().map(this::mapRoomView).toList());
  }

  protected RoomView mapRoomView(RoomRepository.DbRoom room) {
    return new RoomView(
      room.id(),
      room.name(),
      room.ownerId(),
      room.clubberIds(),
      room.bookId());
  }
}
