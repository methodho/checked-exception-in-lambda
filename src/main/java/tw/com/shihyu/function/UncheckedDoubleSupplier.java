package tw.com.shihyu.function;

import java.util.function.DoubleSupplier;

/**
 * 
 * @author Matt S.Y. Ho
 */
@FunctionalInterface
public interface UncheckedDoubleSupplier extends DoubleSupplier {

  @Override
  default double getAsDouble() {
    try {
      return getAsDoubleUnchecked();
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  double getAsDoubleUnchecked() throws Throwable;

}
