package tw.com.shihyu.function;

import java.util.function.DoubleBinaryOperator;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedDoubleBinaryOperator extends DoubleBinaryOperator {

  @Override
  default double applyAsDouble(double left, double right) {
    try {
      return applyAsDoubleUnchecked(left, right);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  double applyAsDoubleUnchecked(double left, double right) throws Throwable;

}
