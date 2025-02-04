package org.codeus.hexagonal.adapter.repository.jpa.repository;

import org.codeus.hexagonal.adapter.repository.jpa.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomEntityRepository extends JpaRepository<RoomEntity, Long> {

  Optional<RoomEntity> findByBook_Isbn(String bookIsbn);
}
