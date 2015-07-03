public class Subset {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        String[] inputs = StdIn.readAllStrings();
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        for (int i = 0; i < inputs.length; ++i) {
            queue.enqueue(inputs[i]);
        }
        for (int i = 0; i < N; ++i) {
            StdOut.println(queue.dequeue());
        }
        
    
    }
}
