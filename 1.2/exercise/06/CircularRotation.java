/**
2.6 A string s is a circular rotation of a string t if it matches when the 
characters are circularly shifted by any number of positions; e.g., ACTGACG is 
a circular shift of TGACGAC, and vice versa. Detecting this condition is 
important in the study of genomic sequences. Write a program that checks 
whether two given strings s and t are circular shifts of one another. 
Hint : The solution is a one-liner with indexOf(), length(), and string 
concatenation.
**/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

class CircularRotation {
	public static boolean isCircularRotaion(String s, String t) {
		for (int i = s.length() -1; i >= 0; --i) {
			String left = s.substring(0, i+1);
			String right = s.substring(i+1);

			if (t.indexOf(right) == 0 
				&& t.indexOf(left, right.length()) == right.length())
				return true;
		}
		return false;
	}

	// This is a very cool one line solution foud on stackoverflow
	public static boolean anotherCoolSolution(String s, String t) {
		return s.length() == t.length() && (t+t).contains(s);
	}

	public static void main(String[] args) {
		while (StdIn.hasNextLine()) {
			String s = StdIn.readLine();
			String t = StdIn.readLine();

			StdOut.println(isCircularRotaion(s, t));
			StdOut.println(anotherCoolSolution(s, t));
		}
	}
}