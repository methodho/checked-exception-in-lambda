package tw.com.shihyu.function;

import java.util.function.UnaryOperator;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 */
@FunctionalInterface
public interface UncheckedUnaryOperator<T> extends UnaryOperator<T> {

  @Override
  default T apply(T t) {
    try {
      return applyUnchecked(t);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  T applyUnchecked(T t) throws Throwable;

}
