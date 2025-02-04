package org.codeus.hexagonal.adapter.rest.client;

import org.codeus.hexagonal.domain.usecase.BookDataAdapter;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class InMemoryBookDataAdapter implements BookDataAdapter {

    private final Map<String, Response> books = Map.of(
      "978-0132350884", new Response("978-0132350884", "Clean Code", "Robert C. Martin", "A handbook of agile software craftsmanship.", LocalDate.of(2008, 8, 1)),
      "978-0134494166", new Response("978-0134494166", "Clean Architecture", "Robert C. Martin", "A guide to software architecture and design principles.", LocalDate.of(2017, 9, 20)),
      "978-0201633610", new Response("978-0201633610", "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "The classic book on design patterns.", LocalDate.of(1999, 10, 8)),
      "978-0321125217", new Response("978-0321125217", "Domain-Driven Design: Tackling Complexity in the Heart of Software", "Eric Evans", "A deep dive into domain-driven design principles.", LocalDate.of(2018, 11, 27)),
      "978-0131177051", new Response("978-0131177051", "Working Effectively with Legacy Code", "Michael C. Feathers", "Refactoring legacy code for improved maintainability.", LocalDate.of(2014, 9, 25))
    );

    @Override
    public Optional<Response> retrieveBookData(Request request) {
        return Optional.ofNullable(books.get(request.bookIsbn()));
    }
}
