public class Exer1_1_22 {

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length-1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi, int intend) {
        for (int i = 0; i < intend; i++)
            System.out.print("\t");
        System.out.println(lo + " ~ " + hi);
        if (lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid-1, intend+1);
        else if (key > a[mid]) return rank(key, a, mid+1, hi, intend+1);
        else return mid;
    }

    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = i;
        }

        rank(3, a);
    }

}
