package tw.com.shihyu.function;

import java.util.function.ObjDoubleConsumer;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 */
@FunctionalInterface
public interface UncheckedObjDoubleConsumer<T> extends ObjDoubleConsumer<T> {

  @Override
  default void accept(T t, double value) {
    try {
      acceptUnchecked(t, value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  boolean acceptUnchecked(T t, double value) throws Throwable;

}
