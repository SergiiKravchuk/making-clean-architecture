package org.codeus.hexagonal.adapter.repository.jpa.repository;

import org.codeus.hexagonal.adapter.repository.jpa.entity.ClubberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubberEntityRepository extends JpaRepository<ClubberEntity, Long> {
}
