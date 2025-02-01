package org.codeus.three_layered_arch.controller.view;

import org.codeus.three_layered_arch.model.Clubber;

public record ClubberView(Long id, String name) {

  public static ClubberView from(Clubber clubber) {
    return new ClubberView(
      clubber.getId(),
      clubber.getName()
    );
  }
}
