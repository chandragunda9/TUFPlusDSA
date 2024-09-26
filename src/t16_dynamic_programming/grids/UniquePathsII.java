package t16_dynamic_programming.grids;

import java.util.Arrays;

public class UniquePathsII {
    public int method1(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        if (matrix[0][0] == 1 || matrix[n - 1][m - 1] == 1)
            return 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return countRec(n - 1, m - 1, matrix, dp);
    }

    public int countRec(int row, int col, int[][] mat, int[][] dp) {
        if (row == 0 && col == 0)
            return 1;
        if (row < 0 || col < 0)
            return 0;
        if (mat[row][col] == 1)
            return 0;
        if (dp[row][col] != -1)
            return dp[row][col];
        int left = countRec(row, col - 1, mat, dp);
        int top = countRec(row - 1, col, mat, dp);
        return dp[row][col] = left + top;
    }

    public int method2(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                    continue;
                }
                int top = 0, left = 0;
                if (j > 0)
                    left = dp[i][j - 1];
                if (i > 0)
                    top = dp[i - 1][j];
                dp[i][j] = top + left;
            }
        }
        return dp[n - 1][m - 1];
    }

    public int uniquePathsWithObstacles(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] prev = new int[m];
        for (int i = 0; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    curr[j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    curr[j] = 1;
                    continue;
                }
                if (j > 0) {
                    curr[j] += curr[j - 1];
                }
                if (i > 0) {
                    curr[j] += prev[j];
                }
            }
            prev = curr;
        }
        return prev[m - 1];
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        UniquePathsII obj = new UniquePathsII();
        System.out.println(obj.method1(mat));
        System.out.println(obj.method2(mat));
        System.out.println(obj.uniquePathsWithObstacles(mat));
    }
}
