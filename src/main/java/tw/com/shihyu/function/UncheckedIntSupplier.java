package tw.com.shihyu.function;

import java.util.function.IntSupplier;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedIntSupplier extends IntSupplier {

  @Override
  default int getAsInt() {
    try {
      return getAsIntUnchecked();
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  int getAsIntUnchecked() throws Throwable;

}
