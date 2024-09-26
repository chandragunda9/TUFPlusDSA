package t16_dynamic_programming.grids;

import java.util.Arrays;

public class CherryPickupII {
    public int cherryPickup(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] next = new int[m][m];

        for (int col1 = 0; col1 < m; col1++) {
            for (int col2 = 0; col2 < m; col2++) {
                if (col1 == col2) {
                    next[col1][col2] = matrix[n - 1][col1];
                } else {
                    next[col1][col2] = matrix[n - 1][col1] + matrix[n - 1][col2];
                }
            }
        }

        for (int row = n - 2; row >= 0; row--) {

            int[][] curr = new int[m][m];
            for (int col1 = 0; col1 < m; col1++) {
                for (int col2 = 0; col2 < m; col2++) {

                    int max = Integer.MIN_VALUE;

                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {

                            int newCol1 = col1 + di;
                            int newCol2 = col2 + dj;

                            if (newCol1 < 0 || newCol2 < 0 || newCol1 == m || newCol2 == m)
                                continue;

                            int cherries = next[newCol1][newCol2];
                            if (col1 == col2) {
                                max = Math.max(max, matrix[row][col1] + cherries);
                            } else {
                                max = Math.max(max, matrix[row][col1] + matrix[row][col2] + cherries);
                            }
                        }
                    }
                    curr[col1][col2] = max;
                }
            }
            next = curr;
        }
        return next[0][m - 1];
    }

    public int method2(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][][] dp = new int[n][m][m];
        for (int col1 = 0; col1 < m; col1++) {
            for (int col2 = 0; col2 < m; col2++) {
                if (col1 == col2) {
                    dp[n - 1][col1][col2] = matrix[n - 1][col1];
                } else {
                    dp[n - 1][col1][col2] = matrix[n - 1][col1] + matrix[n - 1][col2];
                }
            }
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col1 = 0; col1 < m; col1++) {
                for (int col2 = 0; col2 < m; col2++) {

                    int max = Integer.MIN_VALUE;

                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {

                            int newCol1 = col1 + di;
                            int newCol2 = col2 + dj;

                            if (newCol1 < 0 || newCol2 < 0 || newCol1 == m || newCol2 == m)
                                continue;

                            int cherries = dp[row + 1][newCol1][newCol2];
                            if (col1 == col2) {
                                max = Math.max(max, matrix[row][col1] + cherries);
                            } else {
                                max = Math.max(max, matrix[row][col1] + matrix[row][col2] + cherries);
                            }
                        }
                    }
                    dp[row][col1][col2] = max;
                }
            }
        }
        return dp[0][0][m - 1];
    }

    public int method1(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][][] dp = new int[n][m][m];
        for (int[][] rows : dp) {
            for (int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }
        return solve(0, 0, m - 1, n, m, matrix, dp);
    }

    int solve(int row, int col1, int col2, int n, int m, int[][] mat, int[][][] dp) {
        if (col1 < 0 || col2 < 0 || col1 == m || col2 == m)
            return Integer.MIN_VALUE;
        if (row == n - 1) {
            if (col1 == col2)
                return mat[row][col1];
            return mat[row][col1] + mat[row][col2];
        }
        if (dp[row][col1][col2] != -1)
            return dp[row][col1][col2];
        //exploring paths
        int max = Integer.MIN_VALUE;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int cherries = solve(row + 1, col1 + di, col2 + dj, n, m, mat, dp);
                if (cherries == Integer.MIN_VALUE)
                    continue;
                if (col1 == col2) {
                    max = Math.max(max, mat[row][col1] + cherries);
                } else {
                    max = Math.max(max, mat[row][col1] + mat[row][col2] + cherries);
                }
            }
        }
        return dp[row][col1][col2] = max;
    }

    public static void main(String[] args) {
        int[][] mat = {{2, 1, 3}, {4, 2, 5}, {1, 6, 2}, {7, 2, 8}};
        CherryPickupII obj = new CherryPickupII();
        System.out.println(obj.method1(mat));
        System.out.println(obj.method2(mat));
        System.out.println(obj.cherryPickup(mat));
    }
}
