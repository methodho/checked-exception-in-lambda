package tw.com.shihyu.function;

import java.util.function.Supplier;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 */
@FunctionalInterface
public interface UncheckedSupplier<T> extends Supplier<T> {

  @Override
  default T get() {
    try {
      return getUnchecked();
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  T getUnchecked() throws Exception;

}
