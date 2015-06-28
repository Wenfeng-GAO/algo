public class QuickunionUF {
    private int[] id; // access to component id (site indexed)
    private int count; // number of components

    public QuickunionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; ++i)
            id[i] = i;
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
        id[pId] = qId;
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

