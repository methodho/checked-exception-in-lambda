package tw.com.shihyu.function;

import java.util.function.LongToDoubleFunction;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedLongToDoubleFunction extends LongToDoubleFunction {

  @Override
  default double applyAsDouble(long value) {
    try {
      return applyAsDoubleUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  double applyAsDoubleUnchecked(long value) throws Throwable;

}
