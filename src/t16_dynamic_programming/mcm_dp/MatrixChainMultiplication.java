package t16_dynamic_programming.mcm_dp;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public int matrixMultiplication(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n - 1; j++) {
                int minOperations = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int op = nums[i - 1] * nums[k] * nums[j] +
                            dp[i][k] + dp[k + 1][j];
                    minOperations = Math.min(minOperations, op);
                }
                dp[i][j] = minOperations;
            }
        }
        return dp[1][n - 1];
    }

    public int method2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solveMem(1, n - 1, nums, dp);
    }

    int solveMem(int i, int j, int[] nums, int[][] dp) {
        if (i == j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int minOperations = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int op = nums[i - 1] * nums[k] * nums[j] +
                    solveMem(i, k, nums, dp) + solveMem(k + 1, j, nums, dp);
            minOperations = Math.min(minOperations, op);
        }
        return dp[i][j] = minOperations;
    }

    public int method1(int[] nums) {
        return solve(1, nums.length - 1, nums);
    }

    int solve(int i, int j, int[] nums) {
        if (i == j)
            return 0;
        int minOperations = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int op = nums[i - 1] * nums[k] * nums[j] + solve(i, k, nums) + solve(k + 1, j, nums);
            minOperations = Math.min(minOperations, op);
        }
        return minOperations;
    }

    public static void main(String[] args) {
        int[] nums = {10, 15, 20, 25};
        MatrixChainMultiplication obj = new MatrixChainMultiplication();
        System.out.println(obj.method1(nums));
        System.out.println(obj.method2(nums));
        System.out.println(obj.matrixMultiplication(nums));
    }
}
