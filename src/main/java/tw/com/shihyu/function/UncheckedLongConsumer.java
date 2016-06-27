package tw.com.shihyu.function;

import java.util.function.LongConsumer;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedLongConsumer extends LongConsumer {

  @Override
  default void accept(long value) {
    try {
      acceptUnchecked(value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  void acceptUnchecked(long value) throws Throwable;

}
