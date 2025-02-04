package org.codeus.hexagonal.adapter.repository.jpa.repository;

import org.codeus.hexagonal.adapter.repository.jpa.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookEntityRepository extends JpaRepository<BookEntity, String> {
}
