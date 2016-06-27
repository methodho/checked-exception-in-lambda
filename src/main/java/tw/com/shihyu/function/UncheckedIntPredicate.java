package tw.com.shihyu.function;

import java.util.function.IntPredicate;

/**
 * 
 * @author Matt S.Y. Ho
 */
@FunctionalInterface
public interface UncheckedIntPredicate extends IntPredicate {

  @Override
  default boolean test(int value) {
    try {
      return testUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  boolean testUnchecked(int value) throws Throwable;

}
