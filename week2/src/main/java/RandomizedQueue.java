import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

  private Item[] elements;
  private int count;

  public RandomizedQueue() {
    elements = (Item[]) new Object[2];
    count = 0;
  }

  // return the number of items on the queue
  public int size() {
    return count;
  }

  // is the queue empty?
  public boolean isEmpty() {
    return count == 0;
  }

  // add the item
  public void enqueue(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    if (count == elements.length) {
      resize(elements.length * 2);
    }
    elements[count++] = item;
  }

  // resize array according to the specified size
  private void resize(int size) {
    Item[] copy = (Item[]) new Object[size];
    for (int i = 0; i < count; i++) {
      copy[i] = elements[i];
    }
    elements = copy;
  }

  // remove and return a random item
  public Item dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    // resize if using less than half elements
    if (count > 0 && count == elements.length/4) {
      resize(elements.length/2);
    }

    // pick random countedElements
    int index = (new Random()).nextInt(count);
    Item item = elements[index];

    // rearrange elements
    for (int i = index + 1; i < count; i++) {
      elements[i-1] = elements[i];
    }
    elements[--count] = null;

    return item;
  }

  // return (but do not remove) a random item
  public Item sample() {
    int index = (new Random()).nextInt(count);
    return elements[index];
  }

  // return an independent iterator over items in random order
  public Iterator<Item> iterator() {
    return new RandomQueueIterator();
  }

  private class RandomQueueIterator implements Iterator<Item> {

    Item[] copy;
    int countedElements;

    public RandomQueueIterator() {
      copy = (Item []) new Object[count];
      countedElements = 0;
      for (int i = 0; i < count; i++) {
        copy[i] = elements[i];
      }
      StdRandom.shuffle(copy);
    }

    @Override
    public boolean hasNext() {
      return countedElements < count;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return copy[countedElements++];
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
