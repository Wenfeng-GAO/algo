public class WeightedQuickunionUF {
    private int[] id; // access to component id (site indexed)
    private int[] sz; // size of component for roots
    private int count; // number of components

    public WeightedQuickunionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; ++i)
            id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; ++i)
            sz[i] = 1;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId)
            return;
        // Make smaller root point to large one
        if (sz[pId] < sz[qId]) {
            id[pId] = qId;
            sz[qId] += sz[pId];
        } else {
            id[qId] = pId;
            sz[pId] += sz[qId];
        }
        --count;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt(); // Read number od sites
        QuickunionUF uf = new QuickunionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q))
                continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}

