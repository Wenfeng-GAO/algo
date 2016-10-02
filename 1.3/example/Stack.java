import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<T> implements Iterable<T> {
	private Node first;	// top of stack (most recently added node)
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

	public void push(T item) {
		// add item to top of stack
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		++N;
	}

	public T pop() {
		// remove item from top of stack
		T item = first.item;
		first = first.next;
		--N;
		return item;
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

	/** Test client for Stack **/
	public static void main(String[] args) {
		// create a stack and push/pop strings as directed on StdIn
		Stack<String> s = new Stack<String>();

		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				s.push(item);
			} else if (!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}