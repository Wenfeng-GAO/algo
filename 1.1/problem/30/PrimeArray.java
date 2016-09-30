/**
1.1.30 Array exercise. 
Write a code fragment that creates an N-by-N boolean array a[][] such that 
a[i][j] is true if i and j are relatively prime (have no common fac- tors), and 
false otherwise.
**/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

class PrimeArray {
	public static boolean[][] boolArray(int N) {
		boolean[][] A = new boolean[N][N];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				A[i][j] = arePrime(i, j);
			}
		}
		return A;
	}

	private static boolean arePrime(int i, int j) {
		return gcd(i, j) == 1;
	}

	private static int gcd(int p, int q) {
		int t;
		while (q != 0) {
			t = q;
			q = p % q;
			p = t;
		}
		return p;
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		boolean[][] A = boolArray(N);

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				StdOut.print(A[i][j] + "  ");
			}
			StdOut.println();
		}
	}
}