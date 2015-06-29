public class Percolation {
    WeightedQuickunionUF uf;
    int[][] site;
    int n;

    /* create N-by-N grid, with all sites blocked */
    public Percolation(int N) {
        n = N;
        site = new int[N+1][N+1];
        uf = new WeightedQuickunionUF(N*N+2);
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

    /* validate that (i, j) is a valid site */
    private void validate(int i, int j) {
        int N = site.length;
        if (i < 1 || i > N || j < 1 || j > N) {
            throw new IndexOutOfBoundsException("site(" + i
                    + ", " + j + " is out of bound");
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

        if (isOpen(i-1, j))
            uf.union(p, xyTo1D(i-1, j));
        if (isOpen(i+1, j))
            uf.union(p, xyTo1D(i+1, j));
        if (isOpen(i, j-1))
            uf.union(p, xyTo1D(i, j-1));
        if (isOpen(i, j+1))
            uf.union(p, xyTo1D(i, j+1));
    }

    /* test client */
    public static void main(String[] args) {
        Percolation percolation = new Percolation(10);
        percolation.open(1,1);
        percolation.open(1,2);
        if (percolation.uf.connected(1,2))
            System.out.println("OK");
    }
}
