package t1_beginner_problems.patterns;

public class Pattern6 {
    public void pattern6(int n) {
        /*
         * 12345
         * 1234
         * 123
         * 12
         * 1*/

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
