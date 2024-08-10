package t1_beginner_problems.patterns;

public class Pattern5 {
    public void pattern5(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
