package org.codeus.hexagonal.application.usecase;

import org.codeus.hexagonal.domain.adapter.AtomicOperation;
import org.codeus.hexagonal.domain.adapter.BookDataAdapter;
import org.codeus.hexagonal.domain.repository.BookRepository;
import org.codeus.hexagonal.domain.repository.RoomRepository;

public class AtomicCreateRoomUseCase extends CreateRoomUseCaseImpl {

  private final AtomicOperation atomicOperation;

  public AtomicCreateRoomUseCase(RoomRepository roomRepository, BookRepository bookRepository,
                                 BookDataAdapter bookDataAdapter, AtomicOperation atomicOperation) {
    super(roomRepository, bookRepository, bookDataAdapter);
    this.atomicOperation = atomicOperation;
  }

  @Override
  //TODO: make this method atomic (e.g. transactional) because book cannot be created without a room and vice versa
  // OR less restrictive - book can exist without a room but room cannot exist without a book.
  public Response createRoom(Request request) {
    return atomicOperation.execute(() -> super.createRoom(request));
  }
}
