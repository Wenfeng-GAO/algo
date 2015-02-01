//import Stack;

public class E1_3_3 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (item.equals("[") || item.equals("{") || item.equals("(")) {
                stack.push(item);
            } else if (item.equals("]") || item.equals("}") || item.equals(")")) {
                String pop = stack.pop();
                if (pop.equals("[") && item.equals("]") || pop.equals("{") && item.equals("}") || pop.equals("(") && item.equals(")")) ;
                else {
                    StdOut.println("False");
                    return;
                }
            } else {
                StdOut.println("Wrong Input!");
                return;
            }
        }
        StdOut.println("True");

    }
}
