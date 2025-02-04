package org.codeus.hexagonal.application.usecase;


import lombok.RequiredArgsConstructor;
import org.codeus.hexagonal.domain.entity.Clubber;
import org.codeus.hexagonal.domain.repository.ClubberRepository;
import org.codeus.hexagonal.domain.usecase.GetClubberBatchUseCase;

import java.util.List;

@RequiredArgsConstructor
public class GetClubberBatchUseCaseImpl implements GetClubberBatchUseCase {

    private final ClubberRepository clubberRepository;

    @Override
    public List<Clubber> getAllClubbers() {
        return clubberRepository.getClubbers();
    }
}
