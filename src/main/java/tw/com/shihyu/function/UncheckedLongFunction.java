package tw.com.shihyu.function;

import java.util.function.LongFunction;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <R>
 */
@FunctionalInterface
public interface UncheckedLongFunction<R> extends LongFunction<R> {

  @Override
  default R apply(long value) {
    try {
      return applyUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  R applyUnchecked(long value) throws Throwable;

}
