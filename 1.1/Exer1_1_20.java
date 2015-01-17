public class Exer1_1_20 {
    public static double ln(int n) {
        if (n == 1) return 0;
        return Math.log(n) +  ln(n-1);
    }

    public static void main(String[] args) {
        System.out.println(Math.log(6));

        System.out.println(ln(3));
    }
}
