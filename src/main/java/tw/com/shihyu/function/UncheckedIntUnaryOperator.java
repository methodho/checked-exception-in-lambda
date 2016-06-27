package tw.com.shihyu.function;

import java.util.function.IntUnaryOperator;

/**
 * 
 * @author Matt S.Y. Ho
 */
@FunctionalInterface
public interface UncheckedIntUnaryOperator extends IntUnaryOperator {

  @Override
  default int applyAsInt(int operand) {
    try {
      return applyAsIntUnchecked(operand);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  int applyAsIntUnchecked(int operand) throws Throwable;

}
