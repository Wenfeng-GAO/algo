import edu.princeton.cs.algs4.StdOut;
import java.util.Scanner;

class GCD {
	public static long euclid1(int p, int q) {
		int t;
		while (q != 0) {
			t = q;
			q = p % q;
			p = t;
		}
		return p;
	}

	public static long euclid2(int p, int q) {
		int t;

		while (p != q) {
			t = p;
			p = Math.abs(p-q);
			q = t;
		}
		return p;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		long start, end;

		int p, q;
		start = System.nanoTime();
		while (cin.hasNextInt()) {
			p = cin.nextInt();
			q = cin.nextInt();
			euclid2(p, q);
		}
		end = System.nanoTime();
		StdOut.println("Duration: " + (end - start));
	}
}