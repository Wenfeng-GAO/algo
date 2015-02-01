public class UF {
    private int[] id; // access to comonent id (site indexed)
    private int count; // number of components

    public UF(int N) {
        // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count() { return count; }

    public boolean connected(int p, int q) { return find(p) == find(q); }

    public static void main(String[] args) {
        // Solve dynamic connectivity problem on StdIn.
        int N = StdIn.readInt();
        UF uf = new UF(N);
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

    /**
     * 1. Quick-find algo
     */
    public int find(int p) { return id[p]; }

    public void union(int p, int q) {
        // Put p and q into the same component.
        int pId = find(p);
        int qId = find(q);

        // Nothing to do if p and q are already in the same component.
        if (pId == qId) return;

        // Rename p's component to q's name.
        for (int i = 0; i < id.length; i++) 
            if (id[i] == pId) id[i] = qId;
        count--;
    }
}
