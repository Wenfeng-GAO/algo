public class RandomizedQueueTest {
    private static void print(String s) {
        System.out.println(s);
    }

    public static void testEnqueue(int n) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        for (int i = 1; i <= n; ++i) {
            queue.enqueue(i);
        }
        if (queue.size() == n) {
            print("@TestEnqueue: OK");
            print("@TestSize: OK");
        } else {
            print("@TestEnqueue: Failure. size=" + queue.size() +
                    " which should be " + n);
        }
    }

    public static void testDequeue(int n, int d) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        for (int i = 1; i <= n; ++i) {
            queue.enqueue(i);
        }
        for (int i = 0; i < d; ++i) {
            print("@TestDequeue: " + queue.dequeue());
        }
        if (queue.size() == n - d) {
            print("@TestDequeue: OK");
        } else {
            print("@TestDequeue: Failure.  size=" + queue.size() +
                    " which should be " + n);
        }
    }

    public static void testSample(int n, int s) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        for (int i = 1; i <= n; ++i) {
            queue.enqueue(i);
        }
        for (int i = 0; i < s; ++i) {
            print("@TestSample: " + queue.sample());
        }
    }

    public static void testIterator(int n) {
        RandomizedQueue<Double> queue = new RandomizedQueue<Double>();
        for (int i = 1; i <= n; ++i) {
            queue.enqueue((double)i);
        }
        for (Double d : queue) {
            print("@TestIterator: queue1 " + d);
        }
        for (Double d : queue) {
            print("@TestIterator: queue2 " + d);
        }
    }
            
    public static void main(String[] args) {
        // RandomizedQueueTest.testEnqueue(5);
        // RandomizedQueueTest.testDequeue(15, 9);
        // RandomizedQueueTest.testSample(15, 9);
        RandomizedQueueTest.testIterator(10);
    }
}
