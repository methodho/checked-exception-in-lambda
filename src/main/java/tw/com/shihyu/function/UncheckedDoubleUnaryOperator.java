package tw.com.shihyu.function;

import java.util.function.DoubleUnaryOperator;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedDoubleUnaryOperator extends DoubleUnaryOperator {

  @Override
  default double applyAsDouble(double operand) {
    try {
      return applyAsDoubleUnchecked(operand);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  double applyAsDoubleUnchecked(double operand) throws Throwable;

}
