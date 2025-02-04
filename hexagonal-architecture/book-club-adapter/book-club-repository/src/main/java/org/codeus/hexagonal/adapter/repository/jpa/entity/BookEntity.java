package org.codeus.hexagonal.adapter.repository.jpa.entity;

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
public class BookEntity {
  @Id
  private String isbn;

  private String title;
  private String author;
  private String description;
  private LocalDate publishedAt;

  @CreationTimestamp
  private LocalDateTime addedAt;
}
