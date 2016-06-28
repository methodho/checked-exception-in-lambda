package tw.com.shihyu.function;

import java.util.function.BiPredicate;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 * @param <U>
 */
@FunctionalInterface
public interface UncheckedBiPredicate<T, U> extends BiPredicate<T, U> {

  @Override
  default boolean test(T t, U u) {
    try {
      return testUnchecked(t, u);
    } catch (final Throwable throwable) {
      throw Unchecked.rethrow(throwable);
    }
  }

  boolean testUnchecked(T t, U u) throws Throwable;

}
