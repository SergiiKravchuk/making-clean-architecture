package org.codeus.hexagonal.adapter.repository.jpa.mapper;

import lombok.experimental.UtilityClass;
import org.codeus.hexagonal.adapter.repository.jpa.entity.BookEntity;
import org.codeus.hexagonal.domain.repository.BookRepository;

@UtilityClass
public class BookEntityMapper {

  public BookRepository.DbBook to(BookEntity entity) {
    return new BookRepository.DbBook(
      entity.getIsbn(),
      entity.getTitle(),
      entity.getAuthor(),
      entity.getDescription(),
      entity.getPublishedAt()
    );
  }

  public BookEntity from(BookRepository.DbBook dbBook) {
    return BookEntity.builder()
      .isbn(dbBook.isbn())
      .title(dbBook.title())
      .author(dbBook.author())
      .description(dbBook.description())
      .publishedAt(dbBook.publishedAt())
      .build();
  }
}
