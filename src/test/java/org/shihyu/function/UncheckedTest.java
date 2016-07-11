package org.shihyu.function;


import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.shihyu.function.Unchecked;


public class UncheckedTest {

  @SuppressWarnings("serial")
  public static class FilterableHashMap<K, V> extends HashMap<K, V> {
    public FilterableHashMap<K, V> filter(BiPredicate<K, V> predicate) {
      return entrySet().stream().filter(e -> predicate.test(e.getKey(), e.getValue()))
          .collect(toMap(Entry::getKey, Entry::getValue, (a, b) -> b, FilterableHashMap::new));
    }
  }

  private Collection<Integer> collection;
  private FilterableHashMap<Integer, Integer> map;

  @Before
  public void setUp() {
    collection = IntStream.range(0, 10).mapToObj(Integer::valueOf).collect(toList());
    map = collection.stream().collect(toMap(i -> i, i -> i, (a, b) -> b, FilterableHashMap::new));
  }

  @Test
  public void testBiConsumer() {
    map.forEach(Unchecked.Bi.accept(this::sysoutKeyAndValue));
  }

  private void sysoutKeyAndValue(Object key, Object value) throws Exception {
    System.out.println(key + ": " + value);
  }

  @Test
  public void testBiFunction() {
    int actual = map.computeIfPresent(5, Unchecked.Bi.apply(this::add));
    Assert.assertEquals(5 + 5, actual);
  }

  private int add(int a, int b) throws Exception {
    return a + b;
  }

  @Test
  public void testBiPredicate() {
    int actual = map.filter(Unchecked.Bi.test(this::keyEqualsValue)).size();
    Assert.assertEquals(map.size(), actual);
  }

  private boolean keyEqualsValue(int key, int value) throws Exception {
    return key == value;
  }

  @Test
  public void testConsumer() {
    collection.stream().forEach(Unchecked.accept(this::sysout));
  }

  private void sysout(Object o) throws Exception {
    System.out.println(o);
  }

  @Test
  public void testFunction() {
    long actual = collection.stream().map(Unchecked.apply(this::identity)).count();
    Assert.assertEquals(collection.size(), actual);
  }

  private Integer identity(Integer i) throws Exception {
    return i;
  }

  @Test
  public void testPredicate() {
    long actual = collection.stream().filter(Unchecked.test(this::divisible)).count();
    Assert.assertEquals(collection.size() / 2, actual);
  }

  private boolean divisible(Integer i) throws Exception {
    return i % 2 == 0;
  }

  @Test
  public void testSupplier() {
    long expected = 10;
    long actual = Stream.generate(Unchecked.get(this::random)).limit(expected).count();
    Assert.assertEquals(expected, actual);
  }

  private int random() throws Exception {
    return (int) (Math.random() * 10);
  }
}
