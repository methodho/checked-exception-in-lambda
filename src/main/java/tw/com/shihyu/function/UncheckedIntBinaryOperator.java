package tw.com.shihyu.function;

import java.util.function.IntBinaryOperator;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedIntBinaryOperator extends IntBinaryOperator {

  @Override
  default int applyAsInt(int left, int right) {
    try {
      return applyAsIntUnchecked(left, right);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  int applyAsIntUnchecked(int left, int right) throws Throwable;

}
