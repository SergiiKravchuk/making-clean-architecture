package org.codeus.hexagonal.application.usecase;

import org.codeus.hexagonal.domain.repository.RoomRepository;
import org.codeus.hexagonal.domain.adapter.BookDataAdapter;
import org.codeus.hexagonal.domain.repository.BookRepository;
import org.codeus.hexagonal.domain.usecase.CreateRoomUseCase;

public class CreateRoomUseCaseImpl implements CreateRoomUseCase {

  private final RoomRepository roomRepository;
  private final BookRepository bookRepository;
  private final BookDataAdapter bookDataAdapter;

  public CreateRoomUseCaseImpl(RoomRepository roomRepository, BookRepository bookRepository, BookDataAdapter bookDataAdapter) {
    this.roomRepository = roomRepository;
    this.bookRepository = bookRepository;
    this.bookDataAdapter = bookDataAdapter;
  }

  @Override
  public Response createRoom(Request request) {
    String bookIsbn = request.bookIsbn();

    roomRepository.getRoomByBookIsbn(bookIsbn).ifPresent(room -> {
      throw new RuntimeException("Room for book='%s' is already exist.".formatted(bookIsbn));
    });

    bookRepository.getBook(bookIsbn).ifPresentOrElse(book -> {}, () ->
      bookDataAdapter.retrieveBookData(new BookDataAdapter.Request(bookIsbn))
        .map(this::mapDbBook)
        .map(bookRepository::save)
        .orElseThrow(() -> new RuntimeException("Cannot find book by ISBN=%s".formatted(bookIsbn)))
    );

    return new Response(roomRepository.save(
      new RoomRepository.DbRoom(
        request.roomName(),
        request.ownerId(),
        request.clubberIds(),
        bookIsbn)
    ));
  }

  //FIXME: what is a better place for this code?
  protected BookRepository.DbBook mapDbBook(BookDataAdapter.Response bookData) {
    return new BookRepository.DbBook(
      bookData.isbn(),
      bookData.title(),
      bookData.author(),
      bookData.description(),
      bookData.publishedAt()
    );
  }
}
