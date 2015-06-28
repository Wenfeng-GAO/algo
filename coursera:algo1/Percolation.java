public class Percolation {
    private int[] site;
    private WeightedQuickUnionUF;
    /**
     *  Create N-by-N grid, with all sites blocked
     */
    public Percolation(int N) {
        site = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                site[i][j] = -1;
        uf = new WeitedQuickUnionUF(N*N + 2);
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) {
        site[i-1][j-1] = 
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        return site[i-1][j-1] > 0;
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
    }

    // does the system percolate?
    public boolean percolates() {
    }

    // test client
    public static void main(String[] args) {
    }
