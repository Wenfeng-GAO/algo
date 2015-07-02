import java.util.Iterator;
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1]; // stack items
    private int N = 0;                         // number of items

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        // move stack to a new array of size max
        Item[] tmp = (Item[]) new Object[max];
        for (int i = 0; i < N; ++i) {
            tmp[i] = a[i];
        }
        a = tmp;
    }

    public void push(Item item) {
        // add item to top of stack
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    public Item pop() {
        // remove item from top of stack
        Item item = a[--N];
        a[N] = null; // avoid loitering
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        // support LIFO iteration
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {
        }
    }
}
