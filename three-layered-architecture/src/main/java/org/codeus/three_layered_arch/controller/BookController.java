package org.codeus.three_layered_arch.controller;

import lombok.RequiredArgsConstructor;
import org.codeus.three_layered_arch.controller.response.BookResponse;
import org.codeus.three_layered_arch.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping("/{isbn}")
  public ResponseEntity<BookResponse> getByIsbn(@PathVariable String isbn) {
    return ResponseEntity.ok(BookResponse.from(bookService.getBook(isbn)));
  }
}
