//package week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

  private Node first = null;
  private Node last = null;
  private int elements;

  public Deque() {
    elements = 0;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return elements;
  }

  // add the item to the front
  public void addFirst(Item item) {
    // should skip null items
    shouldSkipNullItems(item);
    Node node = new Node();
    node.item = item;
    if (first == null) {
      first = node;
      last = node;
    } else {
      first.previous = node;
      node.next = first;
      first = node;
    }
    elements++;
  }

  private void shouldSkipNullItems(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Null element is not valid");
    }
  }

  // add the item to the end
  public void addLast(Item item) {
    // should skip null items
    shouldSkipNullItems(item);
    Node node = new Node();
    node.item = item;
    if (last == null) {
      last = node;
      first = node;
    } else {
      node.previous = last;
      last.next = node;
      last = node;
    }
    elements++;
  }

  // remove and return the item from the front
  public Item removeFirst() {
    // java.util.NoSuchElementException when empty
    shouldAvoidEmptyList();

    Item item = first.item;
    if (first == last) {
      first = null;
      last = null;
    } else {
      Node second = first.next;
      second.previous = null;
      first.next = null;
      first = second;
    }
    elements--;
    return item;
  }

  private void shouldAvoidEmptyList() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
  }

  // remove and return the item from the end
  public Item removeLast() {
    // java.util.NoSuchElementException when empty
    shouldAvoidEmptyList();
    Item item = last.item;
    if (first == last) {
      first = null;
      last = null;
    } else {
      Node oldLast = last;
      last = oldLast.previous;
      last.next = null;
      oldLast.previous = null;
      oldLast = null;
    }
    elements--;
    return item;
  }


  // return an iterator over items in order from front to end
  public Iterator<Item> iterator() {
    return new DequeIterator();
  }

  private class Node {
    Item item;
    Node next;
    Node previous;

    @Override
    public String toString() {
      return "Node{" +
              "item=" + item +
              ", next=" + next +
              ", previous=" + previous +
              '}';
    }
  }


  private class DequeIterator<Item> implements Iterator<Item> {

    private Node current = first;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }

    @Override
    public Item next() {
      if (hasNext()) {
        Item item = (Item) current.item;
        current = current.next;
        return item;
      } else {
        throw new NoSuchElementException();
      }
    }
  }
}



