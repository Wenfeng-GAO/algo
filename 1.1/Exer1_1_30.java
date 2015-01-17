public class Exer1_1_30 {

    public static int gcd(int p, int q) {
        return q == 0 ? p : gcd(q, p%q);
    }

    public static boolean areRelativelyPrime(int p, int q) {
        return gcd(p, q) == 1 ? true : false;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        boolean a[][] = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = areRelativelyPrime(i, j);
                System.out.printf("%b\t", a[i][j]);
            }
            System.out.println();
        }
    }
}
