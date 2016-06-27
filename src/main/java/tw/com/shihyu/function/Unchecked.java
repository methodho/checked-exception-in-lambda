package tw.com.shihyu.function;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Wraps checked-exception in a {@link RuntimeException} inside {@link FunctionalInterface}
 * 
 * @author Matt S.Y. Ho
 *
 */
public final class Unchecked {

  private Unchecked() {}

  public static <T, U, R> BiFunction<T, U, R> wrap(UncheckedBiFunction<T, U, R> function) {
    return function::apply;
  }

  public static <T, R> Function<T, R> wrap(UncheckedFunction<T, R> function) {
    return function::apply;
  }

  public static <T> Consumer<T> wrap(UncheckedConsumer<T> comsumer) {
    return comsumer::accept;
  }

  public static <T> Predicate<T> wrap(UncheckedPredicate<T> predicate) {
    return predicate::test;
  }

  public static <T> Supplier<T> wrap(UncheckedSupplier<T> supplier) {
    return supplier::get;
  }

  public static <T, U> BiPredicate<T, U> wrap(UncheckedBiPredicate<T, U> predicate) {
    return predicate::test;
  }

  public static <T, U> BiConsumer<T, U> wrap(UncheckedBiConsumer<T, U> consumer) {
    return consumer::accept;
  }

  /**
   * 
   * <pre>
   * try {
   *   // ...
   * } catch (Throwable throwable) {
   *   throw Unchecked.propagate(throwable);
   * }
   * </pre>
   * 
   * @param throwable
   * @return
   */
  public static RuntimeException propagate(Throwable throwable) {
    Objects.requireNonNull(throwable, "Throwable must not null to propagate");
    if (throwable instanceof RuntimeException) {
      throw (RuntimeException) throwable;
    } else if (throwable instanceof Error) {
      throw (Error) throwable;
    }
    throw new RuntimeException(throwable);
  }

}
