package org.codeus.three_layered_arch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Book {
  @Id
  private String isbn;

  private String title;
  private String author;
  private String description;
  private LocalDate publishedAt;

  @CreationTimestamp
  private LocalDateTime addedAt;
}
