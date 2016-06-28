package tw.com.shihyu.function;

import java.util.function.Function;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 * @param <R>
 */
@FunctionalInterface
public interface UncheckedFunction<T, R> extends Function<T, R> {

  @Override
  default R apply(T t) {
    try {
      return applyUnchecked(t);
    } catch (final Throwable throwable) {
      throw Unchecked.rethrow(throwable);
    }
  }

  R applyUnchecked(T t) throws Throwable;

}
