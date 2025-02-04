package org.codeus.hexagonal.domain.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Book {
  private String isbn;
  private String title;
  private String author;
  private String description;
  private LocalDate publishedAt;
}