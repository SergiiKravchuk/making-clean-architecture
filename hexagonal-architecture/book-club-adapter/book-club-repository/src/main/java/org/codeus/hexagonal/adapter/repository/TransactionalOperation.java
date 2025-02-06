package org.codeus.hexagonal.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.codeus.hexagonal.domain.adapter.AtomicOperation;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class TransactionalOperation implements AtomicOperation {

  private final TransactionTemplate transactionTemplate;

  @Override
  public <R> R execute(Supplier<R> supplier) {
    return transactionTemplate.execute(status -> supplier.get());
  }
}
