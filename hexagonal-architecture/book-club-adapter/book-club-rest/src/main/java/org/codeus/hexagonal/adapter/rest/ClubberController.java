package org.codeus.hexagonal.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.codeus.hexagonal.adapter.rest.dto.ClubberDto;
import org.codeus.hexagonal.domain.usecase.GetClubberUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clubbers")
@RequiredArgsConstructor
public class ClubberController {

    private final GetClubberUseCase clubberUseCase;

    @GetMapping
    public ResponseEntity<List<ClubberDto>> getAllClubbers() {
        return ResponseEntity.ok(clubberUseCase.getAllClubbers()
                .stream()
                .map(ClubberDto::from)
                .toList());
    }
}
