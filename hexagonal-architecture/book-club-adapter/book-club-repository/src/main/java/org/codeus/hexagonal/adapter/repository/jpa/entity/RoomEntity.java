package org.codeus.hexagonal.adapter.repository.jpa.entity;

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
public class RoomEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @ManyToOne
  @JoinColumn(name = "owner_id", nullable = false)
  private ClubberEntity owner;

  @OneToOne
  @JoinColumn(name = "book_id")
  private BookEntity book;

  private int currentChapter;
  private int nextPlannedChapter;

  private String meetingUrl;
  private String discussionBoardUrl;

  @ManyToMany
  @JoinTable(
    name = "room_clubbers",
    joinColumns = @JoinColumn(name = "room_id"),
    inverseJoinColumns = @JoinColumn(name = "clubber_id")
  )
  private Set<ClubberEntity> clubbers = new HashSet<>();

}
