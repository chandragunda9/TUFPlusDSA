package t16_dynamic_programming.subsequences;

import java.util.Arrays;

public class MinCoins {
    public int MinimumCoins(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        //base case
        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0)
                prev[amt] = amt / coins[0];
            else
                prev[amt] = Integer.MAX_VALUE;
        }
        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[amount + 1];
            for (int amt = 0; amt <= amount; amt++) {
                //take case
                int left = Integer.MAX_VALUE;
                if (amt >= coins[ind]) {
                    left = curr[amt - coins[ind]];
                    if (left != Integer.MAX_VALUE)
                        left += 1;
                }
                //not take case
                int right = prev[amt];
                curr[amt] = Math.min(left, right);
            }
            prev = curr;
        }
        return prev[amount] == Integer.MAX_VALUE ? -1 : prev[amount];
    }

    public int method2(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        //base case
        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0)
                dp[0][amt] = amt / coins[0];
            else
                dp[0][amt] = Integer.MAX_VALUE;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int amt = 0; amt <= amount; amt++) {
                //take case
                int left = Integer.MAX_VALUE;
                if (amt >= coins[ind]) {
                    left = dp[ind][amt - coins[ind]];
                    if (left != Integer.MAX_VALUE)
                        left += 1;
                }
                //not take case
                int right = dp[ind - 1][amt];
                dp[ind][amt] = Math.min(left, right);
            }
        }
        return dp[n - 1][amount] == Integer.MAX_VALUE ? -1 : dp[n - 1][amount];
    }

    public int method1(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = solve(n - 1, amount, coins, dp);
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }

    int solve(int ind, int amt, int[] coins, int[][] dp) {
        if (amt == 0)
            return 0;
        if (ind == 0) {
            if (amt % coins[0] == 0)
                return amt / coins[0];
            return Integer.MAX_VALUE;
        }
        if (dp[ind][amt] != -1)
            return dp[ind][amt];
        //take case
        int left = Integer.MAX_VALUE;
        if (amt >= coins[ind]) {
            left = solve(ind, amt - coins[ind], coins, dp);
            if (left != Integer.MAX_VALUE)
                left += 1;
        }
        //not take case
        //0+solve(...)
        int right = solve(ind - 1, amt, coins, dp);
        return dp[ind][amt] = Math.min(left, right);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        int amt = 11;
        MinCoins obj = new MinCoins();
        System.out.println(obj.method1(arr, amt));
        System.out.println(obj.method2(arr, amt));
        System.out.println(obj.MinimumCoins(arr, amt));
    }
}
