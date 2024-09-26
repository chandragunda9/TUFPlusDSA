package t16_dynamic_programming.grids;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        //space optimization
        int[] prev = new int[n];
        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    curr[0] = 1;
                    continue;
                }
                curr[j] = 0;
                if (j > 0) {
                    curr[j] += curr[j - 1];
                }
                curr[j] += prev[j];
            }
            prev = curr;
        }
        return prev[n - 1];
    }

    public int method1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return countRec(m - 1, n - 1, m, n, dp);
    }

    int countRec(int row, int col, int m, int n, int[][] dp) {
        if (row == 0 && col == 0)
            return 1;
        if (row < 0 || col < 0)
            return 0;
        if (dp[row][col] != -1)
            return dp[row][col];
        int topMove = countRec(row - 1, col, m, n, dp);
        int leftMove = countRec(row, col - 1, m, n, dp);
        return dp[row][col] = leftMove + topMove;
    }

    public int method2(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                int left = 0, up = 0;
                if (j > 0)
                    left = dp[i][j - 1];
                if (i > 0)
                    up += dp[i - 1][j];
                dp[i][j] = left + up;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        UniquePaths obj = new UniquePaths();
        System.out.println(obj.method1(m, n));
        System.out.println(obj.method2(m, n));
        System.out.println(obj.uniquePaths(m, n));
    }
}
