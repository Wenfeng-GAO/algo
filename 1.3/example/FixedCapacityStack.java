import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

class FixedCapacityStack<T> {
	private T[] a;	// stack entries
	private int N;	// size

	public FixedCapacityStack(int cap) {
		a = (T[]) new Object[cap];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(T item) {
		a[N++] = item;
	}

	public T pop() {
		return a[--N];
	}

	public static void main(String[] args) {
		FixedCapacityStack<String> s = new FixedCapacityStack<String>(100);

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