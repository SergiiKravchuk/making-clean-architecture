package org.codeus.three_layered_arch.service.impl;

import org.codeus.three_layered_arch.dto.BookData;
import org.codeus.three_layered_arch.model.Book;
import org.codeus.three_layered_arch.repository.BookRepository;
import org.codeus.three_layered_arch.service.BookService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

@Service
public class LocalBookService implements BookService {

  private final BookRepository bookRepository;

  private final Map<String, BookData> books = Map.of(
    "978-0132350884", new BookData("978-0132350884", "Clean Code", "Robert C. Martin", "A handbook of agile software craftsmanship.", LocalDate.of(2008, 8, 1)),
    "978-0134494166", new BookData("978-0134494166", "Clean Architecture", "Robert C. Martin", "A guide to software architecture and design principles.", LocalDate.of(2017, 9, 20)),
    "978-0201633610", new BookData("978-0201633610", "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "The classic book on design patterns.", LocalDate.of(1999, 10, 8)),
    "978-0321125217", new BookData("978-0321125217", "Domain-Driven Design: Tackling Complexity in the Heart of Software", "Eric Evans", "A deep dive into domain-driven design principles.", LocalDate.of(2018, 11, 27)),
    "978-0131177051", new BookData("978-0131177051", "Working Effectively with Legacy Code", "Michael C. Feathers", "Refactoring legacy code for improved maintainability.", LocalDate.of(2014, 9, 25))
  );

  public LocalBookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Optional<BookData> retrieveBookData(String bookIsbn) {
    return Optional.of(books.get(bookIsbn));
  }

  @Override
  public Book getBook(String bookIsbn) {
    return bookRepository.findById(bookIsbn)
      .or(() -> retrieveBookData(bookIsbn).map(this::mapBook).map(bookRepository::save))
      .orElseThrow(() -> new RuntimeException("Cannot find book by ISBN=%s".formatted(bookIsbn)));
  }

  protected Book mapBook(BookData bookData) {
    return Book.builder()
      .isbn(bookData.isbn())
      .title(bookData.title())
      .author(bookData.author())
      .description(bookData.description())
      .publishedAt(bookData.publishedAt())
      .build();
  }
}
