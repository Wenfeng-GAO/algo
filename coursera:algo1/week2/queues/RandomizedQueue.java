/**
 * A randomized queue is similar to stack or queque, except that the item removed
 * is chosen uniformly at random from items in the data structure.
 * @author Wenfeng Gao
 * @date 2015-07-03
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue = (Item[]) new Object[1]; 
    private int N = 0;

    /* construct an empty randomized queque */
    public RandomizedQueue() {
    }

    /* is the queue empty? */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* return the number of items on the queue */
    public int size() {
        return N;
    }

    /* add the item */
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (size() == queue.length) {
            resize(2 * queue.length);
        }
        queue[N++] = item;
    }

    /* remove and return a random item */
    public Item dequeue() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        if (size() < queue.length / 4) {
            resize(queue.length / 2);
        }
        swap(queue, StdRandom.uniform(size()), size() - 1);
        return queue[--N];
    }

    /* return (but do not remove) a random item */
    public Item sample() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return queue[StdRandom.uniform(size())];
    }

    /* return an independent iterator over items in random order */
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        int n = size();

        public boolean hasNext() {
            return n != 0;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            swap(queue, StdRandom.uniform(n), n-1);
            Item togo = queue[n-1];
            --n;
            return togo;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void resize(int max) {
        Item[] tmp = (Item[]) new Object[max];
        for (int i = 0; i < size(); ++i) {
            tmp[i] = queue[i];
        }
        queue = tmp;
    }

    private void swap(Item[] items, int i, int j) {
        Item tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    /* unit testing */
    public static void main(String[] args) {
    }
}
