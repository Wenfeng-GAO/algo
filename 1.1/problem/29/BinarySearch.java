import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

class BinarySearch {
	public static int rank(int key, int[] a) {
		// Array must be sorted.
		int lo = 0;
		int hi = a.length - 1;
		int mid;
		int n = 0;

		while (lo <= hi) {
			// Key is in a[lo..hi] or not present.
			mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				n += mid - lo + 1;
				lo = mid + 1;
			} else {
				n += mid - lo;
				break;
			}
		}
		return n;
	}

	public static int count(int key, int[] a) {
		int lo, hi, mid, n;

		lo = 0;
		hi = a.length - 1;
		n = 0;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				++n;
				int i = mid;
				while (a[++i] == key)
					++n;
				i = mid;
				while (a[--i] == key)
					--n;
				break;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		final int TEST_TIMES = 20;
		final int N = 20;
		final int L = 10000; // Random limit
		int[] nums = new int[N];

		for (int i = 0; i < TEST_TIMES; ++i) {
			for (int j = 0; j < N; ++j) {
				nums[j] = StdRandom.uniform(L);
			}
			Arrays.sort(nums);

			// Print array
			for (int j = 0; j < N; ++j) {
				StdOut.print(nums[j] + " ");
			}
			StdOut.println();
			int key = StdRandom.uniform(L);
			StdOut.println("Key: " + key);

			StdOut.println("Rank: " + rank(key, nums));
			StdOut.println("Count " + count(key, nums));
		}
	}
}