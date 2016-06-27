package tw.com.shihyu.function;

import java.util.function.LongToIntFunction;

/**
 * 
 * @author Matt S.Y. Ho
 */
@FunctionalInterface
public interface UncheckedLongToIntFunction extends LongToIntFunction {

  @Override
  default int applyAsInt(long value) {
    try {
      return applyAsIntUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  int applyAsIntUnchecked(long value) throws Throwable;

}
