import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class RandomizedQueueTest {
  RandomizedQueue<String> queue;

  @Before
  public void setUp() {
    queue = new RandomizedQueue();
  }

  @Test
  public void shouldBeEmptyWhenCreated() {
    assertThat(queue.size(), is(equalTo(0)));
  }

  @Test
  public void shouldIncreaseSizeWhenElementIsAdded() {
    queue.enqueue("item");
    assertThat(queue.size(), is(equalTo(1)));
  }

  @Test(expected = IllegalArgumentException.class )
  public void shouldFireIllegalArgumentWhenNullIsAdded() {
    queue.enqueue(null);
  }

  @Test(expected = NoSuchElementException.class)
  public void shouldFireNoSuchElementExceptionWhenQueueIsEmpty() {
    queue.dequeue();
  }

  @Test
  public void shouldDecreaseSizeAfterRemoveItemFromQueue() {
    queue.enqueue("item");
    assertThat(queue.size(), is(equalTo(1)));
    queue.dequeue();
    assertThat(queue.size(), is(equalTo(0)));
  }

  @Test
  public void shouldEnqueueFiveElements() {
    queue.enqueue("item 1");
    queue.enqueue("item 2");
    queue.enqueue("item 3");
    queue.enqueue("item 4");
    queue.enqueue("item 5");
    assertThat(queue.size(), is(equalTo(5)));
  }

  @Test
  public void shouldDequeueNonNullItem() {
    queue.enqueue("item");
    assertThat(queue.size(), is(equalTo(1)));
    assertThat(queue.dequeue(), is(notNullValue()));
    assertThat(queue.size(), is(equalTo(0)));
  }

  @Test
  public void shouldDequeueFiveElements() {
    queue.enqueue("item 1");
    queue.enqueue("item 2");
    queue.enqueue("item 3");
    queue.enqueue("item 4");
    queue.enqueue("item 5");
    assertThat(queue.size(), is(equalTo(5)));
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    assertThat(queue.size(), is(equalTo(0)));
  }

  @Test
  public void shouldNotDecreaseSizeAfterSampleItemFromQueue() {
    queue.enqueue("item");
    queue.sample();
    assertThat(queue.size(), is(equalTo(1)));
  }

  @Test
  public void shouldSampleNonNullItem() {
    queue.enqueue("item");
    assertThat(queue.sample(), is(notNullValue()));
    assertThat(queue.size(), is(equalTo(1)));
  }

  @Test(expected = NoSuchElementException.class)
  public void shouldFireNoSuchElementWhenCallsNextOnIteratorAndQueueIsEmpty() {
    queue.iterator().next();
  }

  @Test(expected = UnsupportedOperationException.class)
  public void shouldFireUnsupportedOperationExceptionWhenRemoveIsCalledOnIterator() {
    queue.iterator().remove();
  }

  @Test
  public void shouldDequeueItem() {
    queue.isEmpty(); //     ==> true
    queue.enqueue("24");
    System.out.println(queue.size());//        ==> 1
    System.out.println(queue.size());//        ==> 1
    queue.enqueue("6");
    queue.enqueue("20");
    queue.enqueue("40");
    System.out.println(queue.size());//        ==> 1
    queue.isEmpty();//     ==> false
    queue.dequeue();
  }

  @Test
  public void test() {
    queue.size();//        ==> 0
    queue.isEmpty();//     ==> true
    queue.isEmpty();//     ==> true
    queue.enqueue("449");
    queue.enqueue("279");
    queue.dequeue();
  }

}
