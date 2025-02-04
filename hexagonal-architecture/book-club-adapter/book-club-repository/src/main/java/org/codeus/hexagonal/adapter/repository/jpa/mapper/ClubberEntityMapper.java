package org.codeus.hexagonal.adapter.repository.jpa.mapper;

import lombok.experimental.UtilityClass;
import org.codeus.hexagonal.adapter.repository.jpa.entity.ClubberEntity;
import org.codeus.hexagonal.domain.entity.Clubber;
import org.codeus.hexagonal.domain.entity.Role;

@UtilityClass
public class ClubberEntityMapper {

    public Clubber toClubber(ClubberEntity clubberEntity){
        return Clubber.builder()
                .id(clubberEntity.getId())
                .name(clubberEntity.getName())
                .role(Role.valueOf(clubberEntity.getRole().name()))
                .build();
    }
}
