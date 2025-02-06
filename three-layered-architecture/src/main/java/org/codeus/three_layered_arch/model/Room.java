package org.codeus.three_layered_arch.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @ManyToOne
  @JoinColumn(name = "owner_id", nullable = false)
  private Clubber owner;

  @OneToOne
  @JoinColumn(name = "book_id")
  private Book book;

  @ManyToMany
  @JoinTable(
    name = "room_clubbers",
    joinColumns = @JoinColumn(name = "room_id"),
    inverseJoinColumns = @JoinColumn(name = "clubber_id")
  )
  private Set<Clubber> clubbers = new HashSet<>();

}
