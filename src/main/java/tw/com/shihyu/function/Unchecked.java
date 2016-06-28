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
 * Wraps checked-exception in a {@link RuntimeException}
 * 
 * @author Matt S.Y. Ho
 *
 */
public final class Unchecked {

  private Unchecked() {}

  // to prevent ambiguous type
  public final static class Bi {
    private Bi() {}

    public static <T, U, R> BiFunction<T, U, R> apply(UncheckedBiFunction<T, U, R> function) {
      return function::apply;
    }

    public static <T, U> BiConsumer<T, U> accept(UncheckedBiConsumer<T, U> consumer) {
      return consumer::accept;
    }

    public static <T, U> BiPredicate<T, U> test(UncheckedBiPredicate<T, U> predicate) {
      return predicate::test;
    }
  }

  public static <T, R> Function<T, R> apply(UncheckedFunction<T, R> function) {
    return function::apply;
  }

  public static <T> Consumer<T> accept(UncheckedConsumer<T> comsumer) {
    return comsumer::accept;
  }

  public static <T> Predicate<T> test(UncheckedPredicate<T> predicate) {
    return predicate::test;
  }

  public static <T> Supplier<T> get(UncheckedSupplier<T> supplier) {
    return supplier::get;
  }

  /**
   * Throwable will be rethrown as is if it is an {@code RuntimeException} or {@code Error}.
   * Otherwise, it will be rethrown wrapped in a {@code RuntimeException}
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
  public static RuntimeException rethrow(Throwable throwable) {
    Objects.requireNonNull(throwable, "Throwable must not null to propagate");
    if (throwable instanceof RuntimeException) {
      throw (RuntimeException) throwable;
    } else if (throwable instanceof Error) {
      throw (Error) throwable;
    }
    throw new RuntimeException(throwable);
  }

}
