/**
1.1.31 Random connections. Write a program that takes as command-line arguments 
an integer N and a double value p (between 0 and 1), plots N equally spaced dots
of size .05 on the circumference of a circle, and then, with probability p for 
each pair of points, draws a gray line connecting them.
**/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;

class RandomConnections {

	public static void main(String[] args) {
		final int R = 4;

		// Input N(number of points) and p(possibility)
		int N = StdIn.readInt();
		double p = StdIn.readDouble();

		Point[] points = new Point[N];

		StdDraw.setScale(-5, 5);
		StdDraw.setPenRadius(0.025);
        StdDraw.setPenColor(StdDraw.BLUE);
		
		// Draw N points place in circle
		for (int i = 0; i < N; ++i) {
			double d = 1.0 * i / N * Math.PI * 2;
			double x = Math.cos(d) * R;
			double y = Math.sin(d) * R;
			StdDraw.point(x, y);
			points[i] = new Point(x, y);
		}

		// Draw lines
		StdDraw.setPenColor(StdDraw.GRAY);
		for (int i = 0; i < N; ++i) {
			for (int j = i+1; j < N; ++j) {
				if (StdRandom.uniform() <= p) {
					StdDraw.line(points[i].x, points[i].y, 
						points[j].x, points[j].y);
				}
			}
		}

	}	
}

class Point {
	public double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}