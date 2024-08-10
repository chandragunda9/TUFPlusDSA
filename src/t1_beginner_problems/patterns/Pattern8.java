package t1_beginner_problems.patterns;

public class Pattern8 {
    public void pattern8(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * (n - 1 - i) + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
