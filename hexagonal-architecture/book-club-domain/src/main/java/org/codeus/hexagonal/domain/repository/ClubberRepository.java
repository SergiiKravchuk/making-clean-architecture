package org.codeus.hexagonal.domain.repository;

import org.codeus.hexagonal.domain.entity.Clubber;

import java.util.List;

public interface ClubberRepository {
    List<Clubber> getClubbers();

}
