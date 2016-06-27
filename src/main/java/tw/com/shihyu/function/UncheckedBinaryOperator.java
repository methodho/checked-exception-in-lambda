package tw.com.shihyu.function;

import java.util.function.BinaryOperator;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 */
@FunctionalInterface
public interface UncheckedBinaryOperator<T> extends BinaryOperator<T> {

  @Override
  default T apply(T t, T u) {
    try {
      return applyUnchecked(t, u);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  T applyUnchecked(T t, T u) throws Throwable;

}
