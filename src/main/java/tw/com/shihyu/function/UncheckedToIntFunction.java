package tw.com.shihyu.function;

import java.util.function.ToIntFunction;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 */
@FunctionalInterface
public interface UncheckedToIntFunction<T> extends ToIntFunction<T> {

  @Override
  default int applyAsInt(T value) {
    try {
      return applyAsIntUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  int applyAsIntUnchecked(T value) throws Throwable;

}
