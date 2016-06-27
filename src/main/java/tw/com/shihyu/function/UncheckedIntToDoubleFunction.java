package tw.com.shihyu.function;

import java.util.function.IntToDoubleFunction;

/**
 * 
 * @author Matt S.Y. Ho
 */
@FunctionalInterface
public interface UncheckedIntToDoubleFunction extends IntToDoubleFunction {

  @Override
  default double applyAsDouble(int value) {
    try {
      return applyAsDoubleUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  double applyAsDoubleUnchecked(int value) throws Throwable;

}
