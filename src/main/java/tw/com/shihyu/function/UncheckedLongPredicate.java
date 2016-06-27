package tw.com.shihyu.function;

import java.util.function.LongPredicate;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedLongPredicate extends LongPredicate {

  @Override
  default boolean test(long value) {
    try {
      return testUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  boolean testUnchecked(long t) throws Throwable;

}
