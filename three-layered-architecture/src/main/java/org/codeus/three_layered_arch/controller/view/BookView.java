package org.codeus.three_layered_arch.controller.view;

import org.codeus.three_layered_arch.model.Book;

public record BookView(String isbn, String title, String author) {

  public static BookView from(Book book) {
    return new BookView(
      book.getIsbn(),
      book.getTitle(),
      book.getAuthor()
    );
  }
}
