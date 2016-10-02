import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Bag<T> implements Iterable<T> {
	private Node first;	// first node in list
	private int N;		// number of items

	private class Node {
		// nested class to define nodes
		T item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void add(T item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		++N;
	}

	public Iterator<T>  iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<T> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public  T next() {
			T item = current.item;
			current = current.next;
			return item;
		}
	}

	/** Test client for Bag **/
	public static void main(String[] args) {
		Bag<String> bag = new Bag<String>();

		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			bag.add(item);
		}

		for (String s : bag) {
			StdOut.print(s + " ");
		}
		StdOut.println();
	}
}