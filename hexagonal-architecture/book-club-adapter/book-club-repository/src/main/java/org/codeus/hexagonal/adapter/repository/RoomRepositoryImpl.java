package org.codeus.hexagonal.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.codeus.hexagonal.adapter.repository.jpa.mapper.RoomEntityMapper;
import org.codeus.hexagonal.adapter.repository.jpa.repository.RoomEntityRepository;
import org.codeus.hexagonal.domain.repository.RoomRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RoomRepositoryImpl implements RoomRepository {

  private final RoomEntityRepository roomEntityRepository;

  @Override
  public Long save(DbRoom room) {
    return roomEntityRepository.save(RoomEntityMapper.from(room)).getId();
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
