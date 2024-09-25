package t16_dynamic_programming.one_dp;

import java.util.Arrays;

public class FrogJump {
    public int frogJump(int[] heights) {
        int prev2 = 0, prev = 0;
        int n = heights.length;
        for (int i = 1; i < n; i++) {
            int oneJump = prev + Math.abs(heights[i] - heights[i - 1]);
            int twoJump = Integer.MAX_VALUE;
            if (i > 1) {
                twoJump = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }
            int curr = Math.min(oneJump, twoJump);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public int method2(int[] heights) {
        int[] dp = new int[heights.length];
        dp[0] = 0;
        for (int i = 1; i < heights.length; i++) {
            int oneStep = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int twoStep = Integer.MAX_VALUE;
            if (i > 1)
                twoStep = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            dp[i] = Math.min(oneStep, twoStep);
        }
        return dp[heights.length - 1];
    }

    public int method1(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n - 1, heights, dp);
    }

    int solve(int ind, int[] heights, int[] dp) {
        if (ind == 0)
            return 0;
        if (ind == 1)
            return Math.abs(heights[ind] - heights[ind - 1]);
        if (dp[ind] != -1)
            return dp[ind];
        int oneStep = Math.abs(heights[ind] - heights[ind - 1]) + solve(ind - 1, heights, dp);
        int twoStep = Math.abs(heights[ind] - heights[ind - 2]) + solve(ind - 2, heights, dp);
        return dp[ind] = Math.min(oneStep, twoStep);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4};
        FrogJump obj = new FrogJump();
        System.out.println(obj.method1(arr));
        System.out.println(obj.frogJump(arr));
    }
}
