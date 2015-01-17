public class Exer1_1_19 {

    public static long F(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return F(n-1) + F(n-2);
    }

    public static void main(String[] args) {
        for (int n = 0; n < 100; n++)
            System.out.println(n + " " + F(n));
    }
}

