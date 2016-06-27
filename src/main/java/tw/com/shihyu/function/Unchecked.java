package tw.com.shihyu.function;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;

/**
 * Wraps checked-exception in a {@link RuntimeException} inside {@link FunctionalInterface}
 * 
 * @author Matt S.Y. Ho
 *
 */
public final class Unchecked {

  private Unchecked() {}

  public static <T, R> Function<T, R> wrap(UncheckedFunction<T, R> function) {
    return function::apply;
  }

  public static <T> ToLongFunction<T> wrap(UncheckedToLongFunction<T> function) {
    return function::applyAsLong;
  }

  public static <T, U> ToLongBiFunction<T, U> wrap(UncheckedToLongBiFunction<T, U> function) {
    return function::applyAsLong;
  }

  public static <T> ToDoubleFunction<T> wrap(UncheckedToDoubleFunction<T> function) {
    return function::applyAsDouble;
  }

  public static <T, U> ToIntBiFunction<T, U> wrap(UncheckedToIntBiFunction<T, U> function) {
    return function::applyAsInt;
  }

  public static <T> ToIntFunction<T> wrap(UncheckedToIntFunction<T> function) {
    return function::applyAsInt;
  }

  public static <T> UnaryOperator<T> wrap(UncheckedUnaryOperator<T> operator) {
    return operator::apply;
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

  public static <T> ObjLongConsumer<T> wrap(UncheckedObjLongConsumer<T> consumer) {
    return consumer::accept;
  }

  public static <T> ObjIntConsumer<T> wrap(UncheckedObjIntConsumer<T> consumer) {
    return consumer::accept;
  }

  public static <T> ObjDoubleConsumer<T> wrap(UncheckedObjDoubleConsumer<T> consumer) {
    return consumer::accept;
  }

  public static LongUnaryOperator wrap(UncheckedLongUnaryOperator operator) {
    return operator::applyAsLong;
  }

  public static LongToIntFunction wrap(UncheckedLongToIntFunction function) {
    return function::applyAsInt;
  }

  public static LongToDoubleFunction wrap(UncheckedLongToDoubleFunction function) {
    return function::applyAsDouble;
  }

  public static LongSupplier wrap(UncheckedLongSupplier supplier) {
    return supplier::getAsLong;
  }

  public static LongPredicate wrap(UncheckedLongPredicate predicate) {
    return predicate::test;
  }

  public static <R> LongFunction<R> wrap(UncheckedLongFunction<R> function) {
    return function::apply;
  }

  public static LongConsumer wrap(UncheckedLongConsumer consumer) {
    return consumer::accept;
  }

  public static LongBinaryOperator wrap(UncheckedLongBinaryOperator operator) {
    return operator::applyAsLong;
  }

  public static IntUnaryOperator wrap(UncheckedIntUnaryOperator operator) {
    return operator::applyAsInt;
  }

  public static IntToLongFunction wrap(UncheckedIntToLongFunction function) {
    return function::applyAsLong;
  }

  public static IntToDoubleFunction wrap(UncheckedIntToDoubleFunction function) {
    return function::applyAsDouble;
  }

  public static IntSupplier wrap(UncheckedIntSupplier supplier) {
    return supplier::getAsInt;
  }

  public static IntPredicate wrap(UncheckedIntPredicate predicate) {
    return predicate::test;
  }

  public static <R> IntFunction<R> wrap(UncheckedIntFunction<R> function) {
    return function::apply;
  }

  public static IntConsumer wrap(UncheckedIntConsumer consumer) {
    return consumer::accept;
  }

  public static IntBinaryOperator wrap(UncheckedIntBinaryOperator operator) {
    return operator::applyAsInt;
  }

  public static DoubleUnaryOperator wrap(UncheckedDoubleUnaryOperator operator) {
    return operator::applyAsDouble;
  }

  public static DoubleToLongFunction wrap(UncheckedDoubleToLongFunction function) {
    return function::applyAsLong;
  }

  public static DoubleToIntFunction wrap(UncheckedDoubleToIntFunction function) {
    return function::applyAsInt;
  }

  public static DoubleSupplier wrap(UncheckedDoubleSupplier supplier) {
    return supplier::getAsDouble;
  }

  public static DoublePredicate wrap(UncheckedDoublePredicate predicate) {
    return predicate::test;
  }

  public static <R> DoubleFunction<R> wrap(UncheckedDoubleFunction<R> function) {
    return function::apply;
  }

  public static DoubleConsumer wrap(UncheckedDoubleConsumer consumer) {
    return consumer::accept;
  }

  public static DoubleBinaryOperator wrap(UncheckedDoubleBinaryOperator operator) {
    return operator::applyAsDouble;
  }

  public static BooleanSupplier wrap(UncheckedBooleanSupplier supplier) {
    return supplier::getAsBoolean;
  }

  public static <T, U> BiPredicate<T, U> wrap(UncheckedBiPredicate<T, U> predicate) {
    return predicate::test;
  }

  public static <T> BinaryOperator<T> wrap(UncheckedBinaryOperator<T> operator) {
    return operator::apply;
  }

  public static <T, R> Function<T, R> wrap(UncheckedBiFunction<T, R> function) {
    return function::apply;
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
