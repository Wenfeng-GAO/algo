public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<Double>();

        while(!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }

        int n = numbers.size();

        double sum = .0;
        for (double x : numbers) {
            sum += x;
        }
        double mean = sum / n;

        sum = .0;
        for (double x : numbers) {
            sum += (mean - x) * (mean - x);
        }
        double std = Math.sqrt(sum/(n-1));

        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);

    }
}

