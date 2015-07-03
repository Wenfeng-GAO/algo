/**
 * A double-ended queue or deque is a generalization of a stack and a queue 
 * that supports adding and removing items from either the front or the back
 * of the data structure.
 * @author Wenfeng Gao
 * @date 2015-07-02
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int N = 0; // number of items
    // first node of the queue(front)
    private final Node<Item> head = new Node<Item>(null); 
    // last node of the queue(last)
    private final Node<Item> tail = new Node<Item>(null); 

    /* construct an empty deque */
    public Deque() {
        head.next = tail;
        tail.previous = head;
    }

    /* is the deque empty? */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* return the number of items on the deque */
    public int size() {
        return N;
    }

    /* add the item to the front */
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node<Item> toAdd = new Node<Item>(item);
        Node<Item> before = head.next;
        head.connectRight(toAdd);
        toAdd.connectRight(before);
        ++N;
    }

    /* add the item to the end */
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node<Item> toAdd = new Node<Item>(item);
        Node<Item> before = tail.previous;
        before.connectRight(toAdd);
        toAdd.connectRight(tail);
        ++N;
    }

    /* remove and return the item from the front */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty, can't remove");
        }
        Node<Item> togo = head.next;
        head.connectRight(togo.next);
        togo.previous = null;
        togo.next = null;
        --N;
        return togo.item;
    }

    /* remove and return the item from the end */
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty, can't remove");
        }
        Node<Item> togo = tail.previous;
        togo.previous.connectRight(tail);
        togo.previous = null;
        togo.next = null;
        --N;
        return togo.item;
    }

    /* return an iterator over items in order from front to end */
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node<Item> curr = head.next;

        public boolean hasNext() {
            return curr != tail;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = curr.item;
            curr = curr.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove"
                    + " in the iterator");
        }
    }

    private class Node<Item> {

        private final Item item;
        private Node<Item> previous, next;

        public Node(Item item) {
            this.item = item;
        }

        public void connectRight(Node<Item> other) {
            this.next = other;
            other.previous = this;
        }
    }

    /* unit testing */
    public static void main(String[] args) {
    }
}
