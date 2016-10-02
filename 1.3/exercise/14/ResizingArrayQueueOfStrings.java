import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueueOfStrings {
	private String[] a;
	private int N;
	private int cap;
	private int head, tail;

	public ResizingArrayQueueOfStrings() {
		this.cap = 1;
		this.head = 0;
		this.tail = 0;
		this.N = 0;
		this.a = new String[cap];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void enqueue(String s) {
		++N;
		if (tail >= cap) {
			tail -= cap;
		}
		a[tail++] = s;
		// printA();

		if (N == this.cap) {
			reisze(this.cap * 2);
		}
	}

	public String dequeue() {
		assert !isEmpty();

		--N;
		if (head >= cap) {
			head -= cap;
		}
		String s = a[head];
		a[head] = null;
		++head;

		if (N == this.cap / 4) {
			reisze(this.cap / 2);
		}

		return s;
	}

	private void reisze(int n) {
		String[] r = new String[n];
		int left = Math.min(head, tail);

		for (int i = 0; i < N; ++i) {
			r[i] = a[left+i];
		}

		this.a = r;
		this.cap = n;
		this.head = 0;
		this.tail = N;
	}

	private void printA() {
		StdOut.print("A: " + N + " head:" + head + " tail:" + tail + " " );
		for (int i = 0; i < a.length; ++i) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

	public static void main(String[] args) {
		ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
		while (!StdIn.isEmpty()) {
			queue.enqueue(StdIn.readString());
		}

		while (!queue.isEmpty()) {
			StdOut.print(queue.dequeue() + " ");
		}
		StdOut.println();
	}
}