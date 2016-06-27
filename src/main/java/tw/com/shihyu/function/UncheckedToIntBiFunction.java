package tw.com.shihyu.function;

import java.util.function.ToIntBiFunction;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 * @param <U>
 */
@FunctionalInterface
public interface UncheckedToIntBiFunction<T, U> extends ToIntBiFunction<T, U> {

  @Override
  default int applyAsInt(T t, U u) {
    try {
      return applyAsIntUnchecked(t, u);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  int applyAsIntUnchecked(T t, U u) throws Throwable;

}
