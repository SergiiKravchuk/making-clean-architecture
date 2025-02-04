package org.codeus.hexagonal.domain.usecase;

import org.codeus.hexagonal.domain.entity.Clubber;

import java.util.List;

public interface GetClubberBatchUseCase {
    List<Clubber> getAllClubbers();
}
