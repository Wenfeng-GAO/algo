public class PercolationStats {
    double[] fraction;

    /* perform T independent experiments on an N-by-N grid */
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0)
            throw new IllegalArgumentException("N or T cannot less than 0");

        fraction = new double[T];
        for (int i = 0; i < T; ++i) 
            fraction[i] = threshold(N);
    }

    /* sample mean of percolation threshold */
    public double mean() {
        return StdStats.mean(fraction);
    }

    /* sample standard deviation of percolation threshold */
    public double stddev() {
        return StdStats.stddev(fraction);
    }

    /* low endpoint of 95% confidence interval */
    public double confidenceLo() {
        return mean() - 1.96*stddev()/Math.sqrt(fraction.length);
    }

    /* high endpoint of 95% confidence interval */
    public double confidenceHi() {
        return mean() + 1.96*stddev()/Math.sqrt(fraction.length);
    }

    /* get threshold of an experiment */
    private double threshold(int N) {
        int n = 0; // the n-th site opened
        Percolation percolation = new Percolation(N);
        
        while (!percolation.percolates()) {
            int x = StdRandom.uniform(N) + 1;
            int y = StdRandom.uniform(N) + 1;
            while (percolation.isOpen(x, y)) {
                x= StdRandom.uniform(N)+ 1;
                y= StdRandom.uniform(N) + 1;
            }
            percolation.open(x, y);
            ++n;
        }
        return (double)n / (double)(N*N);
    }

    /* test client */
    public static void main(String[] args) {
        if (args.length == 2) {
            int N = Integer.parseInt(args[0]);
            int T = Integer.parseInt(args[1]);
            PercolationStats perco = new PercolationStats(N, T);
            StdOut.println("mean:" + perco.mean());
            StdOut.println("stdDev:" + perco.stddev());
            StdOut.println("confidence interval:" + perco.confidenceLo()
                    +", " + perco.confidenceHi());
        }
    }

}
