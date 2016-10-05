import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class TwoSumFaster {
	public static int twoSum(int[] A) {
		int i = 0;
		int j = A.length - 1;
		int sum, cnt = 0;

		while (i < j) {
			sum = A[i] + A[j];
			if (sum == 0) {
				StdOut.println(A[i] + " " + A[j]);
				++cnt;
				++i;
				--j;
			} else if (sum > 0) {
				--j;
			} else {
				++i;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		final int N = 100;
		int[] A = new int[N];

		for (int i = 0; i < N; ++i) {
			A[i] = StdRandom.uniform(-1000, 1000);
		}

		Arrays.sort(A);

		StdOut.println(twoSum(A));
	}
}