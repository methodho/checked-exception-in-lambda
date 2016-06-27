package tw.com.shihyu.function;

import java.util.function.IntFunction;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <R>
 */
@FunctionalInterface
public interface UncheckedIntFunction<R> extends IntFunction<R> {

  @Override
  default R apply(int value) {
    try {
      return applyUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  R applyUnchecked(int value) throws Throwable;

}
