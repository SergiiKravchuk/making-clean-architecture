package org.codeus.hexagonal.domain.entity;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
  private Long id;
  private String name;
  private Clubber owner;
  private Book book;
  private Set<Clubber> clubbers;

  //TODO 1: add logic to domain object (e.g. checking if a room can attach one more clubber) to showcase how domain object handles the business rules
  //TODO 2: add tests to showcase how it looks and what benefits it gives
}
