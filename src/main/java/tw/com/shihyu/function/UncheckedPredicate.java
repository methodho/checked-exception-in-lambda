package tw.com.shihyu.function;

import java.util.function.Predicate;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 */
@FunctionalInterface
public interface UncheckedPredicate<T> extends Predicate<T> {

  @Override
  default boolean test(T t) {
    try {
      return testUnchecked(t);
    } catch (final Throwable throwable) {
      throw Unchecked.rethrow(throwable);
    }
  }

  boolean testUnchecked(T t) throws Throwable;

}
