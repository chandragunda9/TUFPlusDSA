package t16_dynamic_programming.grids;

import java.util.Arrays;

public class TriangleSum {
    public int method1(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, triangle, dp);
    }

    int solve(int row, int col, int[][] triangle, int[][] dp) {
        if (row == triangle.length - 1)
            return triangle[row][col];
        if (dp[row][col] != -1)
            return dp[row][col];
        //bottom
        int bottom = solve(row + 1, col, triangle, dp);
        //bottom right
        int bottomRight = solve(row + 1, col + 1, triangle, dp);
        return dp[row][col] = triangle[row][col] + Math.min(bottom, bottomRight);
    }

    public int method2(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                //bottom
                int bottom = dp[row + 1][col];
                //bottom right
                int bottomRight = dp[row + 1][col + 1];
                dp[row][col] = triangle[row][col] + Math.min(bottom, bottomRight);
            }
        }
        return dp[0][0];
    }

    public int minTriangleSum(int[][] triangle) {
        int n = triangle.length;
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            next[i] = triangle[n - 1][i];
        }
        for (int row = n - 2; row >= 0; row--) {
            int[] curr = new int[n];
            for (int col = 0; col <= row; col++) {
                //bottom
                int bottom = next[col];
                //bottom right
                int bottomRight = next[col + 1];
                curr[col] = triangle[row][col] + Math.min(bottom, bottomRight);
            }
            next = curr;
        }
        return next[0];
    }

    public static void main(String[] args) {
        int[][] arr = {{1}, {4, 7}, {4, 10, 50}, {-50, 5, 6, -100}};
        TriangleSum obj = new TriangleSum();
        System.out.println(obj.method1(arr));
        System.out.println(obj.method2(arr));
        System.out.println(obj.minTriangleSum(arr));
    }
}
