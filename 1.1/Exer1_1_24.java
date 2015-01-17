public class Exer1_1_24 {
    public static int gcd(int p, int q) {
        System.out.println("p = " + p +  "   q = " + q);
        return q == 0 ? p : gcd(q, p%q);
    }
    
    public static void main(String[] args) {
        System.out.println(gcd(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
}
