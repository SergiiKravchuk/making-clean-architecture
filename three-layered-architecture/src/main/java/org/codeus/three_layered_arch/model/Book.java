package org.codeus.three_layered_arch.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
  @Id
  private String isbn;

  private String title;
  private String author;
  private String description;
  private LocalDate publishedAt;

  @CreationTimestamp
  private Instant addedAt;
}
