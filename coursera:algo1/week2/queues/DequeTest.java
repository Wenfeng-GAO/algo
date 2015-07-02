public class DequeTest {
    public void testDeque() {
        System.out.println("Test");
    }

    public static void testSize(int n) {
        Deque<Integer> deques = new Deque<Integer>();
        for (int i = 0; i < n; ++i) {
            deques.addFirst(i);
        }
        if (n == deques.size()) {
            System.out.println("@TestSize: OK");
        } else {
            System.out.println("@TestSize: Failure. n=" + deques.size());
        }
    }

    public static void testAddLast(int n) {
        Deque<Integer> deques = new Deque<Integer>();
        for (int i = 0; i < n; ++i) {
            deques.addLast(i);
        }
        int shouldBe = 0;
        for (Integer i : deques) {
            if (i != shouldBe) {
                System.out.println("@TestAddLast: Failure. i="
                        + i + " , which should be " + shouldBe);
                break;
            }
            ++shouldBe;
        }
        System.out.println("@TestAddLast: OK");
    }

    public static void testRemoveFirst(int n, int r) {
        Deque<Integer> deques = new Deque<Integer>();
        for (int i = 0; i < n; ++i) {
            deques.addLast(i);
        }
        for (int i = 0; i < r; ++i) {
            deques.removeFirst();
        }
        int shouldBe = r;
        for (Integer i : deques) {
            if (i != shouldBe) {
                System.out.println("@TestRemoveFirst: Failure. i="
                        + i + " , which should be " + shouldBe);
                break;
            }
            ++shouldBe;
        }
        System.out.println("@TestRemoveFirst: OK");
    }

    public static void testRemoveLast(int n, int r) {
        Deque<Integer> deques = new Deque<Integer>();
        for (int i = 0; i < n; ++i) {
            deques.addLast(i);
        }
        for (int i = 0; i < r; ++i) {
            deques.removeLast();
        }
        int shouldBe = 0;
        for (Integer i : deques) {
            if (i != shouldBe) {
                System.out.println("@TestRemoveFirst: Failure. i="
                        + i + " , which should be " + shouldBe);
                break;
            }
            ++shouldBe;
        }
        System.out.println("@TestRemoveLast: OK");
    }


    public static void testIterator(int n) {
        Deque<Double> deques = new Deque<Double>();
        for (int i = 0; i < n; ++i) {
            deques.addFirst((double)i);
        }
        for (Double d : deques) {
            System.out.println("@TestIterator: " + d);
        }
    }

    public static void main(String[] args) {
        DequeTest.testSize(5);
        DequeTest.testIterator(10);
        DequeTest.testAddLast(10);
        DequeTest.testRemoveFirst(10, 4);
        DequeTest.testRemoveLast(10, 4);
    }

}
