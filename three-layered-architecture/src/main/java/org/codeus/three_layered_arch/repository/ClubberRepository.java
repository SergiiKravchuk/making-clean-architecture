package org.codeus.three_layered_arch.repository;

import org.codeus.three_layered_arch.model.Clubber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubberRepository extends JpaRepository<Clubber, Long> {
}

