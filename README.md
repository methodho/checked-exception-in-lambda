# Checked exception in lambda

## Example

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

Now become:

```java
Stream.of(...).map(Unchecked.apply(Class::forName)).forEach(...);
```
