package org.codeus.hexagonal.adapter.repository.jpa.mapper;

import lombok.experimental.UtilityClass;
import org.codeus.hexagonal.adapter.repository.jpa.entity.BookEntity;
import org.codeus.hexagonal.domain.repository.BookRepository;

@UtilityClass
public class BookEntityMapper {

  public BookRepository.DbBook to(BookEntity entity) {
    //TODO 1: finish mapper
  }

  public BookEntity from(BookRepository.DbBook dbBook) {
    //TODO 1
  }
}
