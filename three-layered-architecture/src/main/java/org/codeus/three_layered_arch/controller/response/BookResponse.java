package org.codeus.three_layered_arch.controller.response;

import org.codeus.three_layered_arch.model.Book;

import java.time.LocalDate;

public record BookResponse(
  String isbn,
  String title,
  String author,
  String description,
  LocalDate publishedAt) {

  public static BookResponse from(Book book) {
    return new BookResponse(
      book.getIsbn(),
      book.getTitle(),
      book.getAuthor(),
      book.getDescription(),
      book.getPublishedAt()
    );
  }
}
