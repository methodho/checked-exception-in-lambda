package tw.com.shihyu.function;

import java.util.function.DoubleConsumer;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedDoubleConsumer extends DoubleConsumer {

  @Override
  default void accept(double value) {
    try {
      acceptUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  void acceptUnchecked(double value) throws Throwable;

}
