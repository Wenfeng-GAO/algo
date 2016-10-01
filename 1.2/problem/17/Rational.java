import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

class Rational {
	private int numerator;
	private int denominator;

	/**
	We assume that the demoninator never be 0.
	**/
	public Rational(int numerator, int denominator) {
		long gcd = gcd(numerator, denominator);
		this.numerator = numerator / (int)gcd;
		this.denominator = denominator / (int)gcd;
	}

	/**
	sum of this number and b
	**/
	Rational plus(Rational b) {
		long n = this.numerator * b.denominator 
		+ b.numerator * this.denominator;
		long d = this.denominator * b.denominator;
		long gcd = gcd(n, d);

		n /= gcd;
		d /= gcd;

		assert (n <= Integer.MAX_VALUE && n >= Integer.MIN_VALUE
			&& d <= Integer.MAX_VALUE && d >= Integer.MIN_VALUE) :
		"The sum is too large.";

		return new Rational((int)n, (int)d);
	}

	/**
	difference of this number and b
	**/
	Rational minus(Rational b) {
		long n = this.numerator * b.denominator 
		- b.numerator * this.denominator;
		long d = this.denominator * b.denominator;
		long gcd = gcd(n, d);

		n /= gcd;
		d /= gcd;

		assert (n <= Integer.MAX_VALUE && n >= Integer.MIN_VALUE
			&& d <= Integer.MAX_VALUE && d >= Integer.MIN_VALUE) :
		"The sum is too large.";

		return new Rational((int)n, (int)d);
	}

	/**
	product of this number and b
	**/
	Rational times(Rational b) {
		long gcd1 = gcd(this.numerator, b.denominator);
		long gcd2 = gcd(this.denominator, b.numerator);
		long n = this.numerator / gcd1 * b.numerator / gcd2;
		long d = this.denominator / gcd2 * b.denominator / gcd1;

		assert (n <= Integer.MAX_VALUE && n >= Integer.MIN_VALUE
			&& d <= Integer.MAX_VALUE && d >= Integer.MIN_VALUE) :
		"The sum is too large.";

		final Rational res = new Rational((int)n, (int)d);
		assert (res.divides(b).equals(this)) : "product of " + this + " and " 
			+ b + " returned wrong answer.";

		return res;
	}

	/**
	quotient of this number and b
	**/
	Rational divides(Rational b) {
		// Rational t = new Rational(b.denominator, b.numerator);
		// return this.times(t);
		long gcd1 = gcd(this.numerator, b.numerator);
		long gcd2 = gcd(this.denominator, b.denominator);
		long n = this.numerator / gcd1 * b.denominator / gcd2;
		long d = b.numerator / gcd1 * this.denominator / gcd2;

		assert (n <= Integer.MAX_VALUE && n >= Integer.MIN_VALUE
			&& d <= Integer.MAX_VALUE && d >= Integer.MIN_VALUE) :
		"The sum is too large.";

		return new Rational((int)n, (int)d);
	}

	boolean equals(Rational that) {
		return this.numerator == that.numerator 
			&& this.denominator == that.denominator;
	}

	public String toString() {
		return numerator + " / " + denominator;
	}

	private boolean withinLimit(long n) {
		return n < Integer.MAX_VALUE && n > Integer.MIN_VALUE;
	}

	private long gcd(long a, long b) {
		long t;
		while (b != 0) {
			t = b;
			b = a % b;
			a = t;
		}
		return a == 0 ? 1 : a;
	}

	public static void main(String[] args) {
		final int TEST_CASE = 10;
		final int RANDOM_RANGE = 10000;

		for (int i = 0; i < TEST_CASE; ++i) {
			Rational a = new Rational(
				StdRandom.uniform(1, RANDOM_RANGE),
				StdRandom.uniform(1, RANDOM_RANGE));
			Rational b = new Rational(
				StdRandom.uniform(1, RANDOM_RANGE),
				StdRandom.uniform(1, RANDOM_RANGE));
			Rational c = a.plus(b);
			Rational d = a.minus(b);
			Rational e = a.times(b);
			Rational f = a.divides(b);
			StdOut.println("a = " + a);
			StdOut.println("b = " + b);
			StdOut.println("a + b = " + c);
			StdOut.println("a - b = " + d);
			StdOut.println("a * b = " + e);
			StdOut.println("a / b = " + f);
			StdOut.println();
		}

		Rational a = new Rational(4, 8);
		Rational b = new Rational(1, 2);
		StdOut.println("a = " + a);
		StdOut.println("b = " + b);
		StdOut.println("Is a == b ? " + a.equals(b));
	}
}