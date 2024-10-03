package t16_dynamic_programming.subsequences;

import java.util.Arrays;

public class ZeroOneKnapsack {
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        int[] prev = new int[W + 1];
        for (int w = wt[0]; w <= W; w++) {
            prev[w] = val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int w = W; w >= 0; w--) {
                //take case
                int left = 0;
                if (w >= wt[ind])
                    left = val[ind] + prev[w - wt[ind]];
                //not take case
                int right = prev[w];
                prev[w] = Math.max(left, right);
            }
        }
        return prev[W];
    }

    public int method3(int[] wt, int[] val, int n, int W) {
        int[] prev = new int[W + 1];
        for (int w = wt[0]; w <= W; w++) {
            prev[w] = val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[W + 1];
            for (int w = 0; w <= W; w++) {
                //take case
                int left = 0;
                if (w >= wt[ind])
                    left = val[ind] + prev[w - wt[ind]];
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
        for (int w = wt[0]; w <= W; w++) {
            dp[0][w] = val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int w = 0; w <= W; w++) {
                //take case
                int left = 0;
                if (w >= wt[ind])
                    left = val[ind] + dp[ind - 1][w - wt[ind]];
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

    int solve(int ind, int targetWeight, int[] wt, int[] val, int[][] dp) {
        if (ind == 0) {
            if (targetWeight >= wt[ind])
                return val[ind];
            return 0;
        }
        if (dp[ind][targetWeight] != -1) {
            return dp[ind][targetWeight];
        }
        //take case
        int left = 0;
        if (targetWeight >= wt[ind])
            left = val[ind] + solve(ind - 1, targetWeight - wt[ind], wt, val, dp);
        //not take case
        int right = solve(ind - 1, targetWeight, wt, val, dp);
        return dp[ind][targetWeight] = Math.max(left, right);
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120}, wt = {10, 20, 30};
        int w = 50;
        ZeroOneKnapsack obj = new ZeroOneKnapsack();
        System.out.println(obj.method1(wt, val, wt.length, w));
        System.out.println(obj.method2(wt, val, wt.length, w));
        System.out.println(obj.method3(wt, val, wt.length, w));
        System.out.println(obj.knapsack01(wt, val, wt.length, w));
    }
}
