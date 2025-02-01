package org.codeus.three_layered_arch.dto;

import java.time.LocalDate;

public record BookData(
  String isbn,
  String title,
  String author,
  String description,
  LocalDate publishedAt) {
}
