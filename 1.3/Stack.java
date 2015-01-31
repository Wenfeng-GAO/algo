import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Node first; // top of stack (most recently added node)
    private int N;

    private class Node {
        // nested class to define nodes
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void push(Item item) {
        // Add item to top of stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        // Remove item form top of stack
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node current = first;
        private int i = N;
        public boolean hasNext() { return current != null; }
        public Item next() { 
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove() { }
    }

    // Test client
    public static void main(String[] args) {
        // Create a stack and push/pop strings as directed on StdIn.
        Stack<String> s = new Stack<String>();
        
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");
        for (String item : s)
            StdOut.print(item + " ");
        StdOut.println();
        StdOut.println(s.isEmpty());
    }
}

