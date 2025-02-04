package org.codeus.hexagonal.adapter.repository.jpa.mapper;

import lombok.experimental.UtilityClass;
import org.codeus.hexagonal.adapter.repository.jpa.entity.RoomEntity;
import org.codeus.hexagonal.domain.repository.RoomRepository;

@UtilityClass
public class RoomEntityMapper {

  public RoomRepository.DbRoom to(RoomEntity entity) {
    //TODO 1
  }

  public RoomEntity from(RoomRepository.DbRoom dbBook) {
    //TODO 1
  }
}
