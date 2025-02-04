package org.codeus.hexagonal.adapter.repository.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clubber")
public class ClubberEntity {

  public enum EntityRole {
    ADMIN,
    LIBRARIAN,
    MEMBER
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  private EntityRole role;

  @CreationTimestamp
  private Instant createdAt;
}
