import java.util.Iterator;

class ResizingArrayStack<T> implements Iterable<T> {
	private T[] a = (T[]) new Object[1];	// stack items
	private int N = 0;						// number of items

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void resize(int max) {
		// Move stack to a new array of size max.
		T[] t = (T[]) new Object[max];
		for (int i = 0; i < N; ++i) {
			t[i] = a[i];
		}
		a = t;
	}

	public void push(T item) {
		// Add item to top of stack.
		if (N == a.length) {
			resize(2 * a.length);
		}
		a[N++] = item;
	}

	public T pop() {
		// Remove item from top of stack.
		T item = a[--N];
		a[N] = null;	// avoid loitering
		if (N > 0 && N == a.length / 4) {
			resize(a.length / 2);
		}
		return item;
	}

	public Iterator<T> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<T> {
		// Support LIFO iteration.
		private int i = N;

		public  boolean hasNext() {
			return i > 0;
		}

		public T next() {
			return a[--i];
		}

		public void remove() { }
	}
}