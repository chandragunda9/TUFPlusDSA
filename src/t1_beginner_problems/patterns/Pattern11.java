package t1_beginner_problems.patterns;

public class Pattern11 {
    public void pattern11(int n) {
        for (int i = 1; i <= n; i++) {
            //if row index is odd: 1 otherwise 0
            int x = (i & 1) != 0 ? 1 : 0;
            for (int j = 1; j <= i; j++) {
                System.out.print(x);
//                x = x ^ 1;
                x = 1 - x;
            }
            System.out.println();
        }
    }
}
