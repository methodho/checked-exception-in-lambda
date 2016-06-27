package tw.com.shihyu.function;

import java.util.function.ToLongBiFunction;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 * @param <U>
 */
@FunctionalInterface
public interface UncheckedToLongBiFunction<T, U> extends ToLongBiFunction<T, U> {

  @Override
  default long applyAsLong(T t, U u) {
    try {
      return applyAsLong(t, u);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  long applyAsLongUnchecked(T t, U u) throws Throwable;

}
