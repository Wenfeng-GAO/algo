public class Percolation {
    WeightedQuickUnionUF uf;
    int[][] site;
    int n;

    /* create N-by-N grid, with all sites blocked */
    public Percolation(int N) {
        if (N <= 0)
            throw new IllegalArgumentException("N cannot less than 0");
        n = N;
        site = new int[N+1][N+1];
        uf = new WeightedQuickUnionUF(N*N+2);
    }

    /* open site (row i, column j) if it is not open already */
    public void open(int i, int j) {
        validate(i, j);
        site[i][j] = 1; // mask site as open
        connectAround(i, j);
    }

    /* is site (i, j) open? */
    public boolean isOpen(int i, int j) {
        validate(i, j);
        return site[i][j] == 1;
    }

    /* is site (i, j) is full? */
    public boolean isFull(int i, int j) {
        return uf.connected(0, xyTo1D(i, j));
    }

    /* does the system percolate? */
    public boolean percolates() {
        return uf.connected(0, n*n+1);
    }

    /* validate that (i, j) is a valid site */
    private void validate(int i, int j) {
        int N = site.length;
        if (i < 1 || i > N || j < 1 || j > N) {
            throw new IndexOutOfBoundsException("site(" + i
                    + ", " + j + ") is out of bound");
        }
    }

    /* convert site(x, y) to 1D in uf */
    private int xyTo1D(int x, int y) {
        return (x-1) * n + y;
    }

    /* connect all the open sites around (i, j) */
    private void connectAround(int i, int j) {
        validate(i, j);
        int p = xyTo1D(i, j);

        if (i == 1)
            uf.union(p, 0);
        else if (i == n)
            uf.union(p, n*n+1);

        if (i-1 > 0 && isOpen(i-1, j))
            uf.union(p, xyTo1D(i-1, j));
        if (i+1 <= n && isOpen(i+1, j))
            uf.union(p, xyTo1D(i+1, j));
        if (j-1 > 0 && isOpen(i, j-1))
            uf.union(p, xyTo1D(i, j-1));
        if (j+1 <= n && isOpen(i, j+1))
            uf.union(p, xyTo1D(i, j+1));
    }

    /* test client */
    public static void main(String[] args) {
        Percolation percolation = new Percolation(0);
        percolation.open(1,1);
        percolation.open(2,1);
        percolation.open(3,1);
        percolation.open(4,1);
        percolation.open(5,1);
        percolation.open(1,5);
        
        if (percolation.isFull(1, 5))
            StdOut.println("yeah");
        if (percolation.percolates())
            StdOut.println("percolate");
    }
}
