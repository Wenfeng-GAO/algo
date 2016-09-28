import edu.princeton.cs.algs4.StdOut;

class LnN {
	public static double lnPower(int N) {
		if (N == 0)
			return 0;
		return lnPower(N-1) + Math.log(N);
	}

	public static void main(String[] args) {
		for (int N = 0; N < 100; ++N)
			StdOut.println(N + " " + lnPower(N));
	}
}