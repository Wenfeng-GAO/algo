public class QuickfindUF {

    private int[] id; // access to component id (site indexed)
    private int count; // number of components

    /* Initialize component id array */
    public QuickfindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; ++i)
            id[i] = i;
        count = N;
    }

    /* add connection between p and q */
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId)
            return;

        for (int i = 0; i < id.length; ++i) {
            if (id[i] == pId)
                id[i] = qId;
        }
        --count;
    }

    /* component identifier for p (0 to N-1) */
    public int find(int p) {
        return id[p];
    }

    /* return true if p and q are in the same component */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /* number of components */
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt(); // Read number of sites
        QuickfindUF uf = new QuickfindUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
        StdOut.println(uf.count() + " components");
    }
}
