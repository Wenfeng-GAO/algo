import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Queue<T> implements Iterable<T> {
	private Node first;	// link to least recently added node
	private Node last;	// link to most recently added node
	private int N;		// number of items on the queue

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

	public void enqueue(T item) {
		// add item to the end of the list
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}
		++N;
	}

	public T dequeue() {
		// remove item from the begining of the list
		T item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		--N;
		return item;
	}

	public Iterator<T> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<T> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public T next() {
			T item = current.item;
			current = current.next;
			return item;
		}

		public void remove() { }
	}

	public static void main(String[] args) {
		// create a queue and enqueue/dequeue strings
		Queue<String> q = new Queue<String>();

		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				q.enqueue(item);
			} else if (!q.isEmpty()) {
				StdOut.print(q.dequeue() + " ");
			}
		}
		StdOut.println("(" + q.size() + " left on queue)");
	}
}