package org.codeus.hexagonal.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.codeus.hexagonal.adapter.repository.jpa.entity.RoomEntity;
import org.codeus.hexagonal.adapter.repository.jpa.mapper.RoomEntityMapper;
import org.codeus.hexagonal.adapter.repository.jpa.repository.BookEntityRepository;
import org.codeus.hexagonal.adapter.repository.jpa.repository.ClubberEntityRepository;
import org.codeus.hexagonal.adapter.repository.jpa.repository.RoomEntityRepository;
import org.codeus.hexagonal.domain.repository.RoomRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoomRepositoryImpl implements RoomRepository {

  private final RoomEntityRepository roomEntityRepository;
  private final BookEntityRepository bookEntityRepository;
  private final ClubberEntityRepository clubberEntityRepository;

  @Override
  public Long save(DbRoom room) {
    RoomEntity roomEntity = RoomEntityMapper.partialFrom(room)
      .book(bookEntityRepository.getReferenceById(room.bookId()))
      .owner(clubberEntityRepository.getReferenceById(room.ownerId()))
      .clubbers(room.clubberIds().stream().map(clubberEntityRepository::getReferenceById).collect(Collectors.toSet()))
      .build();

    return roomEntityRepository.save(roomEntity).getId();
  }

  @Override
  public Optional<DbRoom> getRoomById(Long roomId) {
    return roomEntityRepository.findById(roomId).map(RoomEntityMapper::to);
  }

  @Override
  public Optional<DbRoom> getRoomByBookIsbn(String bookIsbn) {
    return roomEntityRepository.findByBook_Isbn(bookIsbn).map(RoomEntityMapper::to);
  }

  @Override
  public List<DbRoom> getAllRooms() {
    return roomEntityRepository.findAll().stream().map(RoomEntityMapper::to).toList();
  }
}
