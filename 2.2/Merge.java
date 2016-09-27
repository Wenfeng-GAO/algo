public class Merge {
    private static Comparable[] aux; // auxiliary array for merges

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length]; // Allocate space just once.
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // Sort a[lo...hi].
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid); // Sort left half.
        sort(a, mid+1, hi); // Sort right half.
        merge(a, lo, mid, hi); // Merge results
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

    // public static void main(String[] args) {
    //     int[] a = {9, 8, 7, 6, 6};
    //     Merge.sort(a);
    //     for (int i = 0; i < a.length; ++i)
    //         System.out.print(a[i] + " ");
    // }
}
