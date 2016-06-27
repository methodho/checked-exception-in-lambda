package tw.com.shihyu.function;

import java.util.function.BooleanSupplier;

/**
 * 
 * @author Matt S.Y. Ho
 *
 */
@FunctionalInterface
public interface UncheckedBooleanSupplier extends BooleanSupplier {

  @Override
  default boolean getAsBoolean() {
    try {
      return getAsBooleanUnchecked();
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  boolean getAsBooleanUnchecked() throws Throwable;

}
