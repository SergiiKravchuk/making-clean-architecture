package org.codeus.hexagonal.config;

import org.codeus.hexagonal.application.usecase.GetClubberUseCaseImpl;
import org.codeus.hexagonal.domain.repository.ClubberRepository;
import org.codeus.hexagonal.domain.usecase.GetClubberUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public GetClubberUseCase getClubberUseCase(ClubberRepository clubberRepository) {
        return new GetClubberUseCaseImpl(clubberRepository);
    }
}
