package org.codeus.hexagonal.domain.adapter;

import java.util.function.Supplier;

public interface AtomicOperation {

  <R> R execute(Supplier<R> supplier);
}
