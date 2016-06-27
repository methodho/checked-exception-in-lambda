package tw.com.shihyu.function;

import java.util.function.ToLongFunction;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 */
@FunctionalInterface
public interface UncheckedToLongFunction<T> extends ToLongFunction<T> {

  @Override
  default long applyAsLong(T value) {
    try {
      return applyAsLongUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  long applyAsLongUnchecked(T value) throws Throwable;

}
