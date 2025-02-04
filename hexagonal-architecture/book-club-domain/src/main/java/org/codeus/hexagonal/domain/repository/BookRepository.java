package org.codeus.hexagonal.domain.repository;

import java.time.LocalDate;
import java.util.Optional;

public interface BookRepository {

  record DbBook(String isbn,
                String title,
                String author,
                String description,
                LocalDate publishedAt) {
  }

  Optional<DbBook> getBook(String bookIsbn);

  String save(DbBook book);

}
