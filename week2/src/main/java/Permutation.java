//package week2;

//import StdIn;
import java.util.Iterator;

public class Permutation {
  public static void main(String[] args) {
    int k = Integer.parseInt(args[0]);
    RandomizedQueue<String> queue = new RandomizedQueue<>();
    String word = null;
    while (!StdIn.isEmpty()) {
      word = StdIn.readString();
      queue.enqueue(word);
    }
    Iterator<String> it = queue.iterator();
    for (int i = 0; i < k; i++) {
      System.out.println(it.next());
    }
  }
}
