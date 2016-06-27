# Checked exception in lambda

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
Stream.of(...).map(Unchecked.warp(Class::forName)).forEach(...);
```

See more in `tw.com.shihyu.function.UncheckedTest`
