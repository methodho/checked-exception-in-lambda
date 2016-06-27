package tw.com.shihyu.function;

import java.util.function.LongSupplier;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedLongSupplier extends LongSupplier {

  @Override
  default long getAsLong() {
    try {
      return getAsLongUnchecked();
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  long getAsLongUnchecked() throws Throwable;

}
