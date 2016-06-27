# Checked exception in lambda

## Example

The old way:

```java
Stream.of(...).map(t -> {
    try {
      // ...
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
}).forEach(...);
```

Now, become:

```java
Stream.of(...).map(Unchecked.apply(Class::forName)).forEach(...);
```
