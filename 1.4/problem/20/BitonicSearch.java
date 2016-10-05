import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class BitonicSearch {
	private static int peak(int[] A) {
		int start, end, mid;

		start = 0;
		end = A.length - 1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (A[mid] > A[mid-1] && A[mid] > A[mid+1]) {
				return mid;
			} else if (A[mid] > A[mid-1]) {
				start = mid + 1;
			} else if (A[mid] > A[mid+1]) {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static boolean search(int[] A, int key) {
		int p = peak(A);
		return Arrays.binarySearch(A, 0, p, key) >= 0
				|| Arrays.binarySearch(A, p+1, A.length-1, key) >= 0;
	}

	/**
	Construct a bitonic array with distinct random values.
	**/
	private static int[] bitonicArray(int size) {
		Set<Integer> set = new HashSet<Integer>();

		while (set.size() != size) {
			set.add(StdRandom.uniform(size * 2));
		}

		assert set.size() == size;
		
		int[] A = new int[size];
		int i = 0;
		for (int n : set) {
			A[i++] = n;
		}
		Arrays.sort(A);
		int p = StdRandom.uniform(2, size-2);
		revserse(A, p, A.length-1);

		return A;
	}

	/**
	To reverse the array in place from index s(start) to e(end).
	**/
	private static void revserse(int[] A, int s, int e) {
		int t;
		while (s < e) {
			t = A[s];
			A[s] = A[e];
			A[e] = t;
			++s;
			--e;
		}
	}

	private static void printArray(int[] A) {
		for (int i = 0; i < A.length; ++i) {
			StdOut.print(A[i] + " ");
		}
		StdOut.println();
	}

	public static void main(String[] args) {
		final int TEST_CASE = 15;	// test times
		final int ARRAY_SIZE = 20;	// the array size of each test case
		for (int i = 1; i <= TEST_CASE; ++i) {
			StdOut.println("TEST " + i);

			int[] T = bitonicArray(ARRAY_SIZE);
			printArray(T);

			int key = StdRandom.uniform(ARRAY_SIZE * 2);
			StdOut.println("Is " + key + " in the array? " + search(T, key));
			StdOut.println();
		}
	}
}