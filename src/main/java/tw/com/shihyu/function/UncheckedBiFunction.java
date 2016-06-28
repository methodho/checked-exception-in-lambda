package tw.com.shihyu.function;

import java.util.function.BiFunction;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 * @param <U>
 * @param <R>
 */
@FunctionalInterface
public interface UncheckedBiFunction<T, U, R> extends BiFunction<T, U, R> {

  @Override
  default R apply(T t, U u) {
    try {
      return applyUnchecked(t, u);
    } catch (final Throwable throwable) {
      throw Unchecked.rethrow(throwable);
    }
  }

  R applyUnchecked(T t, U u) throws Throwable;

}
