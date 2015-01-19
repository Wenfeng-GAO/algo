import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N==0;
    }

    public int size() {
        return N;
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item) {
        if (N == a.length) resize(2*a.length);
        a[N++] = item;
    }
    
    public Item pop() {
        Item item = a[--N];
        a[N] = null; // Avoid loitering
        if (N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public Item next() { return a[--i]; }
        public void remove() { }
    }

    // Test client
    public static void main(String[] args) {
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        
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
    }
}
