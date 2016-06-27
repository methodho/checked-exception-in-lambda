# Checked exception in lambda

## Getting Started

The standard way:

```java
Stream.of(...).map(t -> {
    try {
      return Class.forName(t);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
}).forEach(...);
```

And now become fluently:

```java
Stream.of(...).map(Unchecked.apply(Class::forName)).forEach(...);
```

See more example in `tw.com.shihyu.function.UncheckedTest`

## API

### Function

- `Function`: `Unchecked.apply(..)`
- `BiFunction`: `Unchecked.Bi.apply(..)`

### Consumer

- `Consumer`:  `Unchecked.accept(..)`
- `BiConsumer`:  `Unchecked.Bi.accept(..)`

### Predicate

- `Predicate`:  `Unchecked.test(..)`
- `BiPredicate`:  `Unchecked.Bi.test(..)`

### Supplier

- `Supplier`:  `Unchecked.get(..)`
