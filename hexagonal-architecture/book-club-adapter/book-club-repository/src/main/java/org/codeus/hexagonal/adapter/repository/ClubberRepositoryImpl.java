package org.codeus.hexagonal.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.codeus.hexagonal.adapter.repository.jpa.mapper.ClubberEntityMapper;
import org.codeus.hexagonal.adapter.repository.jpa.repository.ClubberEntityRepository;
import org.codeus.hexagonal.domain.entity.Clubber;
import org.codeus.hexagonal.domain.repository.ClubberRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClubberRepositoryImpl implements ClubberRepository {

    private final ClubberEntityRepository clubberEntityRepository;

    @Override
    public List<Clubber> getClubbers() {
        return clubberEntityRepository.findAll().stream()
                .map(ClubberEntityMapper::toClubber)
                .toList();
    }
}
