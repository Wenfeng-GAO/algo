/*************************************************************************
 * Name: Wenfeng Gao
 * Email: elricfeng@gmail.com
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new PointComparator();

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        double slope;
        if (this.equals(that)) {
            slope = Double.NEGATIVE_INFINITY;
        } else if (this.x == that.x) {
            slope = Double.POSITIVE_INFINITY;
        } else {
            slope = (that.y - this.y) / (that.x - this.x);
        }
        return slope;
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        return (this.y == that.y) ? (this.x - that.x) : (this.y - that.y);
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    class PointComparator implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            return (int)(slopeTo(p1) - slopeTo(p2));
        }
    }

    // unit test
    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 2);
        if (p1.compareTo(p2) < 0 && p2.compareTo(p3) < 0) {
            StdOut.println("@Test-CompareTo: OK.");
        }
        
    }
}
