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
        Item item = fist.item;
        first = first.next;
        N--;
        return item;
    }

