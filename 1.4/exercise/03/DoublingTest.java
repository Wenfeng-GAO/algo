import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;

public class DoublingTest {

	public static double timeTrial(int N) {
		// Time ThreeSum.count() for N random 6-digit ints.
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < N; ++i) {
			a[i] = StdRandom.uniform(-MAX, MAX);
		}

		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);

		return timer.elapsedTime();
	}

	public static void main(String[] args) {
		// StdDraw.enableDoubleBuffering();
		int x = 8500;
		int y = 50;

		StdDraw.setXscale(0, x);
		StdDraw.setYscale(0, y);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.setPenRadius(0.025);

		for (int N = 250; true; N += 250) {
			// Print time for problem size N.
			double time = timeTrial(N);
			StdOut.printf("%7d %5.1f\n", N, time);

			// if (N == x) {
			// 	x += x;
			// 	StdDraw.setXscale(0, x);
			// }

			// if (time == y) {
			// 	y *= 10;
			// 	StdDraw.setYscale(0, y);
			// }

			// StdDraw.clear();
			StdDraw.point(N, time);
			// StdDraw.show();
			// StdDraw.pause(20);
		}
	}
}