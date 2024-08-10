package t1_beginner_problems.patterns;

public class Pattern12 {
    public static void main(String[] args) {
        int n=5;
        pattern12(n);
    }
    public static void pattern12(int n) {
        for (int i = 1; i <= n; i++) {
            //left portion
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            //printing spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            //right portion
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
