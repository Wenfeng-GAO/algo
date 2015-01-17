public class Exer1_1_9 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        System.out.println(Integer.toBinaryString(N));

        String s = "";
        for (int i = N; i > 0; i /= 2) {
            s = i % 2 + s;
        }
        System.out.println(s);

    }
}
