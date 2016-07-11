package org.shihyu.function;

import java.util.function.Consumer;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 */
@FunctionalInterface
public interface UncheckedConsumer<T> extends Consumer<T> {

  @Override
  default void accept(T t) {
    try {
      acceptUnchecked(t);
    } catch (final Throwable throwable) {
      throw Unchecked.rethrow(throwable);
    }
  }

  void acceptUnchecked(T t) throws Throwable;

}
