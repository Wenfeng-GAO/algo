public class MergeBU {
    private static Comparable[] aux; 

    public static void sort(Comparable[] a) {
        // Do lgN passes of pairwise merges.
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N-sz; lo += sz + sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        // Merge a[lo...mid] with a[mid+1...hi].
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; ++k) {
            // Copy a[lo...hi] to aux[lo...hi]
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; ++k) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (Example.less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

}
