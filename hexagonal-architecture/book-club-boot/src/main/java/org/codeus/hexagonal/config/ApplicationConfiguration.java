package org.codeus.hexagonal.config;

import org.codeus.hexagonal.adapter.rest.client.InMemoryBookDataAdapter;
import org.codeus.hexagonal.application.usecase.*;
import org.codeus.hexagonal.domain.adapter.AtomicOperation;
import org.codeus.hexagonal.domain.adapter.BookDataAdapter;
import org.codeus.hexagonal.domain.repository.BookRepository;
import org.codeus.hexagonal.domain.repository.ClubberRepository;
import org.codeus.hexagonal.domain.repository.RoomRepository;
import org.codeus.hexagonal.domain.usecase.CreateRoomUseCase;
import org.codeus.hexagonal.domain.usecase.GetClubberBatchUseCase;
import org.codeus.hexagonal.domain.usecase.GetRoomBatchUseCase;
import org.codeus.hexagonal.domain.usecase.GetRoomUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public GetClubberBatchUseCase getClubberUseCase(ClubberRepository clubberRepository) {
    return new GetClubberBatchUseCaseImpl(clubberRepository);
  }

  @Bean
  public CreateRoomUseCase createRoomUseCase(RoomRepository roomRepository,
                                             BookRepository bookRepository,
                                             BookDataAdapter bookDataAdapter) {
    return new CreateRoomUseCaseImpl(roomRepository, bookRepository, bookDataAdapter);
  }

  @Bean
  @Primary
  public CreateRoomUseCase createAtomicRoomUseCase(RoomRepository roomRepository,
                                                   BookRepository bookRepository,
                                                   BookDataAdapter bookDataAdapter,
                                                   AtomicOperation atomicOperation) {
    return new AtomicCreateRoomUseCase(roomRepository, bookRepository, bookDataAdapter, atomicOperation);
  }

  @Bean
  public GetRoomBatchUseCase getRoomBatchUseCase(RoomRepository roomRepository) {
    return new GetRoomBatchUseCaseImpl(roomRepository);
  }

  @Bean
  public GetRoomUseCase getRoomUseCase(RoomRepository roomRepository) {
    return new GetRoomUseCaseImpl(roomRepository);
  }

  @Bean
  public BookDataAdapter bookDataAdapter() {
    return new InMemoryBookDataAdapter();
  }
}
