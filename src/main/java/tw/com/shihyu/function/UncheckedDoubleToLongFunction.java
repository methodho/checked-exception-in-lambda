package tw.com.shihyu.function;

import java.util.function.DoubleToLongFunction;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedDoubleToLongFunction extends DoubleToLongFunction {

  @Override
  default long applyAsLong(double value) {
    try {
      return applyAsLongUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  long applyAsLongUnchecked(double value) throws Throwable;

}
