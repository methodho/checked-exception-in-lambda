package tw.com.shihyu.function;

import java.util.function.ToDoubleFunction;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 */
@FunctionalInterface
public interface UncheckedToDoubleFunction<T> extends ToDoubleFunction<T> {

  @Override
  default double applyAsDouble(T t) {
    try {
      return applyAsDoubleUnchecked(t);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  double applyAsDoubleUnchecked(T t) throws Throwable;

}
