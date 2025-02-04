package org.codeus.hexagonal.adapter.rest.dto;

import org.codeus.hexagonal.domain.entity.Clubber;
import org.codeus.hexagonal.domain.entity.Role;

public record ClubberDto(Long id, String name, Role role) {
  public static ClubberDto from(Clubber clubber) {
    return new ClubberDto(clubber.getId(), clubber.getName(), clubber.getRole());
  }
}
