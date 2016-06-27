package tw.com.shihyu.function;

import java.util.function.DoublePredicate;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedDoublePredicate extends DoublePredicate {

  @Override
  default boolean test(double value) {
    try {
      return testUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  boolean testUnchecked(double value) throws Throwable;

}
