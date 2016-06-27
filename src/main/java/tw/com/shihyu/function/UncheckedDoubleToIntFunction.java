package tw.com.shihyu.function;

import java.util.function.DoubleToIntFunction;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedDoubleToIntFunction extends DoubleToIntFunction {

  @Override
  default int applyAsInt(double value) {
    try {
      return applyAsIntUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  int applyAsIntUnchecked(double value) throws Throwable;

}
