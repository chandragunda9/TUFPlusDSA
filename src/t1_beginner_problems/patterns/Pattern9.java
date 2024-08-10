package t1_beginner_problems.patterns;

public class Pattern9 {
    public void pattern9(int n) {
        //combination of pattern 7 and pattern 8
        upperPortion(n);
        lowerPortion(n);
    }

    void upperPortion(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void lowerPortion(int n) {
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
