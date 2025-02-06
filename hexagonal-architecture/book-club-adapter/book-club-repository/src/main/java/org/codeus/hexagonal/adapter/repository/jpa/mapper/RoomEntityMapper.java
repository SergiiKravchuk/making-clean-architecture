package org.codeus.hexagonal.adapter.repository.jpa.mapper;

import lombok.experimental.UtilityClass;
import org.codeus.hexagonal.adapter.repository.jpa.entity.ClubberEntity;
import org.codeus.hexagonal.adapter.repository.jpa.entity.RoomEntity;
import org.codeus.hexagonal.domain.repository.RoomRepository;

import java.util.stream.Collectors;

@UtilityClass
public class RoomEntityMapper {

  public RoomRepository.DbRoom to(RoomEntity entity) {
    return new RoomRepository.DbRoom(
      entity.getId(),
      entity.getName(),
      entity.getOwner().getId(),
      entity.getClubbers().stream().map(ClubberEntity::getId).collect(Collectors.toSet()),
      entity.getBook().getIsbn()
    );
  }

  public RoomEntity.RoomEntityBuilder partialFrom(RoomRepository.DbRoom dbBook) {
    return RoomEntity.builder()
      .id(dbBook.id())
      .name(dbBook.name());

  }
}
