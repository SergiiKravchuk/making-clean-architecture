package org.codeus.hexagonal.domain.adapter;

import java.time.LocalDate;
import java.util.Optional;

public interface BookDataAdapter {

  record Request(String bookIsbn) {
  }

  record Response(String isbn,
                  String title,
                  String author,
                  String description,
                  LocalDate publishedAt) {
  }

  Optional<Response> retrieveBookData(Request request);
}
