package tw.com.shihyu.function;

import java.util.function.ObjIntConsumer;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 */
@FunctionalInterface
public interface UncheckedObjIntConsumer<T> extends ObjIntConsumer<T> {

  @Override
  default void accept(T t, int value) {
    try {
      acceptUnchecked(t, value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  boolean acceptUnchecked(T t, int value) throws Throwable;

}
