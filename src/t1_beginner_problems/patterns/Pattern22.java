package t1_beginner_problems.patterns;

public class Pattern22 {
    public void pattern22(int n) {
        for (int i = 0; i <= 2 * n - 2; i++) {
            for (int j = 0; j <= 2 * n - 2; j++) {
                int topDist = i, leftDist = j, bottomDist = 2 * n - 2 - i, rightDist = 2 * n - 2 - j;
                int minDist = Math.min(topDist, leftDist);
                minDist = Math.min(minDist, rightDist);
                minDist = Math.min(minDist, bottomDist);
                System.out.print((n - minDist) + " ");
            }
            System.out.println();
        }
    }
}
