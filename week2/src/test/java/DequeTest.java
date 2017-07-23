import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DequeTest {

  Deque<String> deque;
  @Before
  public void setUp() {
    deque = new Deque<>();
  }
  @Test
  public void shouldInitDequeAsEmpty() {
    assertThat(deque.size(), is(equalTo(0)));
  }

  @Test
  public void shouldAddElementAtFirst() {
    deque.addFirst("item");
    assertThat(deque.size(), is(equalTo(1)));
    assertThat(deque.removeFirst(), is(equalTo("item")));
    assertThat(deque.size(), is(equalTo(0)));
  }

  @Test
  public void shouldAddElementsAtFirst() {
    deque.addFirst("item 1");
    deque.addFirst("item 2");
    assertThat(deque.size(), is(equalTo(2)));
    assertThat(deque.removeFirst(), is(equalTo("item 2")));
    assertThat(deque.size(), is(equalTo(1)));
    assertThat(deque.removeFirst(), is(equalTo("item 1")));
    assertThat(deque.size(), is(equalTo(0)));
  }

  @Test
  public void shouldAddElementsAtFirstAndRemoveLast() {
    deque.addFirst("item 1");
    deque.addFirst("item 2");
    assertThat(deque.size(), is(equalTo(2)));
    assertThat(deque.removeLast(), is(equalTo("item 1")));
    assertThat(deque.size(), is(equalTo(1)));
    assertThat(deque.removeFirst(), is(equalTo("item 2")));
    assertThat(deque.size(), is(equalTo(0)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAddNullAtFirst() {
    deque.addFirst(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAddNullAtLast() {
    deque.addLast(null);
  }

  @Test
  public void shouldAddElementAtLast() {
    deque.addLast("item");
    assertThat(deque.size(), is(equalTo(1)));
    assertThat(deque.removeLast(), is(equalTo("item")));
    assertThat(deque.size(), is(equalTo(0)));
  }

  @Test
  public void shouldAddElementsAtLast() {
    deque.addLast("item 1");
    deque.addLast("item 2");
    assertThat(deque.size(), is(equalTo(2)));
    assertThat(deque.removeLast(), is(equalTo("item 2")));
    assertThat(deque.size(), is(equalTo(1)));
    assertThat(deque.removeLast(), is(equalTo("item 1")));
    assertThat(deque.size(), is(equalTo(0)));
  }

  @Test
  public void shouldRemoveLastAndFirst() {
    deque.addFirst("item 1");
    deque.addFirst("item 2");
    assertThat(deque.removeLast(), is(equalTo("item 1")));
    assertThat(deque.removeFirst(), is(equalTo("item 2")));
  }

  @Test(expected = NoSuchElementException.class)
  public void shouldFireNoSuchElementWhenTriedToRemoveFirstAndIsEmpty() {
    deque.removeFirst();
  }

  @Test(expected = NoSuchElementException.class)
  public void shouldFireNoSuchElementWhenTriedToRemoveLastAndIsEmpty() {
    deque.removeLast();
  }

  @Test(expected = NoSuchElementException.class)
  public void shouldFireNoSuchElementWhenDequeHasNoItems() {
    Iterator<String> iterator = deque.iterator();
    iterator.next();
  }

  @Test(expected = NoSuchElementException.class)
  public void shouldFireNoSuchElementWhenDequeHasRunOutOfItems() {
    deque.addFirst("item 1");
    Iterator<String> iterator = deque.iterator();
    assertThat(iterator.next(), is(equalTo("item 1")));
    iterator.next();
  }

  @Test
  public void shouldIterateOverDeque() {
    deque.addFirst("item 1");
    Iterator<String> iterator = deque.iterator();
    assertThat(iterator.next(), is(equalTo("item 1")));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void shouldFireUnsupportedOperationExceptionWhenRemoveIsCalledOnIterator() {
    deque.iterator().remove();
  }

  @Test
  public void shouldRemoveLastWhenOnlyFirstsWereAdded() {
    deque.addFirst("0");
    deque.addFirst("1");
    deque.addFirst("2");
    deque.removeLast();  //    ==> 0
    deque.addFirst("4");
    deque.addFirst("5");
    deque.addFirst("6");
    deque.addFirst("7");
    deque.removeLast();
  }

  @Test
  public void shouldRemoveFirstWhenOnlyLastWereAdded() {
    deque.addLast("0");
    deque.addLast("1");
    deque.addLast("2");
    deque.removeFirst(); // 0
    deque.addLast("4");
    deque.addLast("5");
    deque.addLast("6");
    deque.addLast("7");
    deque.removeFirst();
  }

  @Test
  public void test() {
    deque.isEmpty();
    deque.isEmpty();
    deque.addLast("2");
    deque.removeFirst(); //     ==> 2
    deque.addLast("4");
    deque.removeFirst();
  }


}
