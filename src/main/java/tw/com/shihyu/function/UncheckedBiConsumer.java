package tw.com.shihyu.function;

import java.util.function.BiConsumer;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 * @param <U>
 */
@FunctionalInterface
public interface UncheckedBiConsumer<T, U> extends BiConsumer<T, U> {

  @Override
  default void accept(T t, U u) {
    try {
      acceptUnchecked(t, u);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  void acceptUnchecked(T t, U u) throws Throwable;

}
