package org.codeus.hexagonal.config;

import org.codeus.hexagonal.adapter.rest.client.InMemoryBookDataAdapter;
import org.codeus.hexagonal.application.usecase.CreateRoomUseCaseImpl;
import org.codeus.hexagonal.application.usecase.GetClubberBatchUseCaseImpl;
import org.codeus.hexagonal.application.usecase.GetRoomBatchUseCaseImpl;
import org.codeus.hexagonal.application.usecase.GetRoomUseCaseImpl;
import org.codeus.hexagonal.domain.adapter.BookDataAdapter;
import org.codeus.hexagonal.domain.repository.BookRepository;
import org.codeus.hexagonal.domain.repository.ClubberRepository;
import org.codeus.hexagonal.domain.repository.RoomRepository;
import org.codeus.hexagonal.domain.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
