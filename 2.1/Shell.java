public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3 * h + 1; // 1, 4, 13, 40...
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; ++i) {
                // Insert a[i] among a[i-h], a[i-2h], ...
                for (int j = i; j >=h && Example.less(a[j], a[j-h]); j-=h) {
                    Example.exch(a, j, j-h);
                }
                h /= 3;
            }
        }
    }
}
