package t16_dynamic_programming.grids;

import java.util.Arrays;

public class MaximumPathSum {
    public int method2(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < m; col++) {
                //top
                int top = dp[row - 1][col];
                int leftDiagonal = Integer.MAX_VALUE;
                int rightDiagonal = Integer.MAX_VALUE;
                //top left
                if (col > 0)
                    leftDiagonal = dp[row - 1][col - 1];
                //top right
                if (col + 1 < m)
                    rightDiagonal = dp[row - 1][col + 1];
                dp[row][col] = matrix[row][col] + Math.min(top, Math.min(leftDiagonal, rightDiagonal));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }

    public int method1(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for (int row = 0; row < n; row++) {
            Arrays.fill(dp[row], -1);
        }
        for (int col = 0; col < m; col++) {
            min = Math.min(min, solve(n - 1, col, matrix, dp));
        }
        return min;
    }

    int solve(int row, int col, int[][] matrix, int[][] dp) {
        if (col < 0 || col == matrix[0].length)
            return Integer.MAX_VALUE;
        if (row == 0)
            return matrix[row][col];
        if (dp[row][col] != -1)
            return dp[row][col];
        //top
        int top = solve(row - 1, col, matrix, dp);
        //top-left
        int topLeft = solve(row - 1, col - 1, matrix, dp);
        //top-right
        int topRight = solve(row - 1, col + 1, matrix, dp);
        return dp[row][col] = matrix[row][col] + Math.min(top, Math.min(topLeft, topRight));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] prev = new int[m];
        for (int i = 0; i < m; i++) {
            prev[i] = matrix[0][i];
        }

        for (int row = 1; row < n; row++) {
            int[] curr = new int[m];
            for (int col = 0; col < m; col++) {
                //top
                int top = prev[col];
                int ld = Integer.MAX_VALUE, rd = Integer.MAX_VALUE;
                //top left
                if (col > 0)
                    ld = prev[col - 1];
                //top right
                if (col + 1 < m)
                    rd = prev[col + 1];
                curr[col] = matrix[row][col] + Math.min(top, Math.min(ld, rd));
            }
            prev = curr;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            min = Math.min(min, prev[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 10, 4}, {100, 3, 2, 1}, {1, 1, 20, 2}, {1, 2, 2, 1}};
        MaximumPathSum obj = new MaximumPathSum();
        System.out.println(obj.method1(mat));
        System.out.println(obj.method2(mat));
        System.out.println(obj.minFallingPathSum(mat));
    }
}
