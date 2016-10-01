/**
1.2.10 Develop a class VisualCounter that allows both increment and decrement 
operations. Take two arguments N and max in the constructor, where N specifies 
the maximum number of operations and max specifies the maximum absolute value 
for the counter. As a side effect, create a plot showing the value of the 
counter each time its tally changes.
**/
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


class VisualCounter {
	private int N;		// Maximum number of operations
	private int max;	// Maximum absolute value
	private int count;

	public VisualCounter(int N, int max) {
		this.N = N;
		this.max = max;
		StdDraw.setXscale(0, 4);
		StdDraw.setYscale(0, max * 2);
		StdDraw.setPenColor(StdDraw.BLUE);
	}

	public void increment() {
		++count;
		StdDraw.clear();
		checkColor();
		StdDraw.filledRectangle(2, tally(), 1, Math.abs(tally()));
		StdDraw.show();
	}

	public void decrement() {
		--count;
		StdDraw.clear();
		checkColor();
		if (tally() > 0) {
			StdDraw.filledRectangle(2, tally(), 1, Math.abs(tally()));
			StdDraw.show();
		}
	}

	public int tally() {
		return count;
	}

	public String toString() {
		return "Vote result: " + count;
	}

	private void checkColor() {
		if (tally() > max) {
			StdDraw.setPenColor(StdDraw.RED);
		} else {
			StdDraw.setPenColor(StdDraw.BLUE);
		}
	}

	// Test client, vote and devote as "+" and "-", you can vote as much times
	// as N, and if tally is more than max, it'll become red.
	public static void main(String[] args) {
		VisualCounter vc = new VisualCounter(StdIn.readInt(), StdIn.readInt());

		for (int i = 0; i < vc.N; ++i) {
			if (!StdIn.isEmpty()) {
				String vote = StdIn.readString();
				if (vote.equals("+")) {
					vc.increment();
				} else if (vote.equals("-")) {
					vc.decrement();
				}
			} else {
				break;
			}
		}

		StdOut.println(vc);
	}
}