/**
1.3.9 Write a program that takes from standard input an expression without left 
pa- rentheses and prints the equivalent infix expression with the parentheses 
inserted. For example, given the input:
1 + 2 ) * 3 - 4 ) * 5- 6 ) ) )
your program should print
( ( 1 + 2 ) * ( ( 3 -4 ) * ( 5 - 6 ) ) )
**/

import java.util.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Infix {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();

		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals(")")) {
				String tok1, tok2, tok3;
				tok3 = stack.pop();
				tok2 = stack.pop();
				tok1 = stack.pop();
				stack.push("( " + tok1 + " " + tok2 + " " + tok3 + " )");
			} else {
				stack.push(s);
			}
		}

		for (String s : stack) {
			StdOut.print(s + " ");
		}
		StdOut.println();
	}
}