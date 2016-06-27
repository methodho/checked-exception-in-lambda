package tw.com.shihyu.function;

import java.util.function.LongBinaryOperator;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedLongBinaryOperator extends LongBinaryOperator {

  @Override
  default long applyAsLong(long left, long right) {
    try {
      return applyAsLongUnchecked(left, right);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  long applyAsLongUnchecked(long left, long right) throws Throwable;

}
