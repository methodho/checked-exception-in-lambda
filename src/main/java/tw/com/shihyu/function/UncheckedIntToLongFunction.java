package tw.com.shihyu.function;

import java.util.function.IntToLongFunction;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedIntToLongFunction extends IntToLongFunction {

  @Override
  default long applyAsLong(int value) {
    try {
      return applyAsLongUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  long applyAsLongUnchecked(int value) throws Throwable;

}
