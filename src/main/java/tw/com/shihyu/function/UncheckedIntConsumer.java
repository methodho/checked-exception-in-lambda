package tw.com.shihyu.function;

import java.util.function.IntConsumer;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedIntConsumer extends IntConsumer {

  @Override
  default void accept(int value) {
    try {
      acceptUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  void acceptUnchecked(int value) throws Throwable;

}
