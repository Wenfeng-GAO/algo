import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Chart2 {

	public static void main(String[] args) {
		int N = 50;
		double[] a = new double[N];

		for (int i = 0; i < N; ++i) {
			a[i] = StdRandom.uniform();
		}

		double x, y, rw, rh;
		for (int i = 0; i < N; ++i) {
			x = 1.0 * i / N;
			y = a[i] / 2.0;
			rw = .5 / N;
			rh = a[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
}