package t16_dynamic_programming.subsequences;

import java.util.Arrays;

public class RodCuttingProblem {
    public int RodCutting(int price[], int n) {
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            int maxProfit = 0;
            for (int cutLen = 1; cutLen <= (n - ind); cutLen++) {
                int val = price[cutLen - 1] + dp[ind + cutLen];
                maxProfit = Math.max(maxProfit, val);
            }
            dp[ind] = maxProfit;
        }
        return dp[0];
    }

    public int method1(int price[], int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int res = solve(0, price, dp);
        System.out.println(Arrays.toString(dp));
        return res;
    }

    int solve(int ind, int[] prices, int[] dp) {
        int n = prices.length;
        if (ind == n)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int maxProfit = 0;
        for (int cutLen = 1; cutLen <= (n - ind); cutLen++) {
            int val = prices[cutLen - 1] + solve(ind + cutLen, prices, dp);
            maxProfit = Math.max(maxProfit, val);
        }
        return dp[ind] = maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9};
        int n = 4;
        RodCuttingProblem obj = new RodCuttingProblem();
        System.out.println(obj.method1(arr, n));
        System.out.println(obj.RodCutting(arr, n));
    }
}
