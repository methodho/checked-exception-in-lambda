package tw.com.shihyu.function;

import java.util.function.LongUnaryOperator;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedLongUnaryOperator extends LongUnaryOperator {

  @Override
  default long applyAsLong(long operand) {
    try {
      return applyAsLongUnchecked(operand);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  long applyAsLongUnchecked(long operand) throws Throwable;

}
