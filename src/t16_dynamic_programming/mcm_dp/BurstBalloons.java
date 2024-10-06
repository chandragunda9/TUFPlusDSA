package t16_dynamic_programming.mcm_dp;

import java.util.Arrays;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        return 0;
    }

    public int method2(int[] nums) {
        int n = nums.length;

        int[] copy = new int[n + 2];
        copy[0] = 1;
        copy[n + 1] = 1;
        System.arraycopy(nums, 0, copy, 1, n);

        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j)
                    continue;
                int maxCost = 0;
                for (int lastBalloonToBurst = i; lastBalloonToBurst <= j; lastBalloonToBurst++) {
                    int val = copy[i - 1] * copy[lastBalloonToBurst] * copy[j + 1] +
                            dp[i][lastBalloonToBurst - 1] + dp[lastBalloonToBurst + 1][j];
                    maxCost = Math.max(maxCost, val);
                }
                dp[i][j] = maxCost;
            }
        }
        return dp[1][n];
    }

    public int method1(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n + 2];
        copy[0] = 1;
        copy[n + 1] = 1;
        System.arraycopy(nums, 0, copy, 1, n);
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(1, n, copy, dp);
    }

    int solve(int i, int j, int[] nums, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int maxCost = 0;
        for (int lastBalloonToBurst = i; lastBalloonToBurst <= j; lastBalloonToBurst++) {
            int val = nums[i - 1] * nums[lastBalloonToBurst] * nums[j + 1] +
                    solve(i, lastBalloonToBurst - 1, nums, dp) + solve(lastBalloonToBurst + 1, j, nums, dp);
            maxCost = Math.max(maxCost, val);
        }
        return dp[i][j] = maxCost;
    }

    public static void main(String[] args) {
        BurstBalloons obj = new BurstBalloons();
        int[] nums = {3, 1, 5, 8};
        System.out.println(obj.method1(nums));
        System.out.println(obj.method2(nums));
    }
}
