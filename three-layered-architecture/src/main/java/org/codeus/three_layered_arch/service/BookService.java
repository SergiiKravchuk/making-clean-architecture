package org.codeus.three_layered_arch.service;

import org.codeus.three_layered_arch.dto.BookData;
import org.codeus.three_layered_arch.model.Book;

import java.util.Optional;

public interface BookService {

  Optional<BookData> retrieveBookData(String bookIsbn);

  Book getBook(String bookIsbn);
}
