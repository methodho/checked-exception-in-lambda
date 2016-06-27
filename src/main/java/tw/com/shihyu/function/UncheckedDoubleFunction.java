package tw.com.shihyu.function;

import java.util.function.DoubleFunction;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <R>
 */
@FunctionalInterface
public interface UncheckedDoubleFunction<R> extends DoubleFunction<R> {

  @Override
  default R apply(double value) {
    try {
      return applyUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  R applyUnchecked(double value) throws Throwable;

}
