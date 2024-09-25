package t16_dynamic_programming.one_dp;

import java.util.Arrays;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int prev = 1, prev2 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    //By using Memoization
    int method1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return count(n, dp);
    }

    int count(int n, int[] dp) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = count(n - 1, dp) + count(n - 2, dp);
    }

    int method2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
