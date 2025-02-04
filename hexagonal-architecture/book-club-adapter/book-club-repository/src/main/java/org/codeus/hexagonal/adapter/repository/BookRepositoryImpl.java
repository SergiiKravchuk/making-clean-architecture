package org.codeus.hexagonal.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.codeus.hexagonal.adapter.repository.jpa.mapper.BookEntityMapper;
import org.codeus.hexagonal.adapter.repository.jpa.repository.BookEntityRepository;
import org.codeus.hexagonal.domain.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

  private final BookEntityRepository bookEntityRepository;

  @Override
  public Optional<DbBook> getBook(String bookIsbn) {
    return bookEntityRepository.findById(bookIsbn).map(BookEntityMapper::to);
  }

  @Override
  public String save(DbBook book) {
    return bookEntityRepository.save(BookEntityMapper.from(book)).getIsbn();
  }
}
