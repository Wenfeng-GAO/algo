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

		if (withinLimit(n) && withinLimit(d)) {
			return new Rational((int)n, (int)d);
		} else {
			return null;
		}
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

		if (withinLimit(n) && withinLimit(d)) {
			return new Rational((int)n, (int)d);
		} else {
			return null;
		}
	}

	/**
	product of this number and b
	**/
	Rational times(Rational b) {
		long gcd1 = gcd(this.numerator, b.denominator);
		long gcd2 = gcd(this.denominator, b.numerator);
		long n = this.numerator / gcd1 * b.numerator / gcd2;
		long d = this.denominator / gcd2 * b.denominator / gcd1;
		if (withinLimit(n) && withinLimit(d)) {
			return new Rational((int)n, (int)d);
		}else {
			return null;
		}
	}

	/**
	quotient of this number and b
	**/
	Rational divides(Rational b) {
		Rational t = new Rational(b.denominator, b.numerator);
		return this.times(t);
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
		final int RANDOM_RANGE = Integer.MAX_VALUE;

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