package org.codeus.three_layered_arch.repository;

import org.codeus.three_layered_arch.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
