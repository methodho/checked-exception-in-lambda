package tw.com.shihyu.function;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Wrap checked exception into unchecked in lambda
 * 
 * @author Matt S.Y. Ho
 *
 */
public abstract class Unchecked {

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
   * 將 {@link Throwable} 轉換成 Unchecked 丟出
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
