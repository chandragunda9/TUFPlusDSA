package t16_dynamic_programming.subsequences;

import java.util.Arrays;

public class UnboundedKnapsack {
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int[] prev = new int[W + 1];
        //base cases
        //basically not use because initializing to zero only
//        for (int ind = 0; ind < n; ind++) {
//            dp[ind][0] = 0;
//        }
        for (int w = wt[0]; w <= W; w++) {
            prev[w] = (w / wt[0]) * val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[W + 1];
            for (int w = 1; w <= W; w++) {
                //take case
                int left = 0;
                if (w >= wt[ind])
                    left = val[ind] + curr[w - wt[ind]];
                //not take case
                int right = prev[w];
                curr[w] = Math.max(left, right);
            }
            prev = curr;
        }
        return prev[W];
    }

    public int method2(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W + 1];
        //base cases
        //basically not use because initializing to zero only
//        for (int ind = 0; ind < n; ind++) {
//            dp[ind][0] = 0;
//        }
        for (int w = wt[0]; w <= W; w++) {
            dp[0][w] = (w / wt[0]) * val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int w = 1; w <= W; w++) {
                //take case
                int left = 0;
                if (w >= wt[ind])
                    left = val[ind] + dp[ind][w - wt[ind]];
                //not take case
                int right = dp[ind - 1][w];
                dp[ind][w] = Math.max(left, right);
            }
        }
        return dp[n - 1][W];
    }

    public int method1(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(n - 1, W, wt, val, dp);
    }

    int solve(int ind, int w, int[] wt, int[] val, int[][] dp) {
        if (w == 0)
            return 0;
        if (ind == 0) {
            if (w >= wt[0])
                return (w / wt[0]) * val[0];
            return 0;
        }
        if (dp[ind][w] != -1)
            return dp[ind][w];
        //take case
        int left = 0;
        if (w >= wt[ind])
            left = val[ind] + solve(ind, w - wt[ind], wt, val, dp);
        //not take case
        int right = solve(ind - 1, w, wt, val, dp);
        return dp[ind][w] = Math.max(left, right);
    }

    public static void main(String[] args) {
//        int[] val = {5, 11, 13}, wt = {2, 4, 6};
//        int W = 10;
        int[] val = {10, 40, 50, 70}, wt = {1, 3, 4, 5};
        int W = 8;
        UnboundedKnapsack obj = new UnboundedKnapsack();
        System.out.println(obj.method1(wt, val, wt.length, W));
        System.out.println(obj.method2(wt, val, wt.length, W));
        System.out.println(obj.unboundedKnapsack(wt, val, wt.length, W));
    }
}
