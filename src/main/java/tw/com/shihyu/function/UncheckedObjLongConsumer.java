package tw.com.shihyu.function;

import java.util.function.ObjLongConsumer;

/**
 * 
 * @author Matt S.Y. Ho
 *
 * @param <T>
 */
@FunctionalInterface
public interface UncheckedObjLongConsumer<T> extends ObjLongConsumer<T> {

  @Override
  default void accept(T t, long value) {
    try {
      acceptUnchecked(t, value);
    } catch (final Throwable throwable) {
      throw Unchecked.propagate(throwable);
    }
  }

  void acceptUnchecked(T t, long value) throws Throwable;

}
