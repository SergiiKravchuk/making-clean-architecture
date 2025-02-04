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
}
