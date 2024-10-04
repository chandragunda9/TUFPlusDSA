package t16_dynamic_programming.subsequences;

import java.util.Arrays;

public class CoinChangeII {
    int mod = (int) (1e9 + 7);

    public int count(int[] coins, int N, int amount) {
        int[] prev = new int[amount + 1];
        prev[0] = 1;

        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0)
                prev[amt] = 1;
        }

        for (int ind = 1; ind < N; ind++) {
            int[] curr = new int[amount + 1];
            curr[0] = 1;
            for (int amt = 1; amt <= amount; amt++) {
                int left = 0;
                //take case
                if (amt >= coins[ind])
                    left = curr[amt - coins[ind]];
                //not take case
                int right = prev[amt];
                curr[amt] = (left + right) % mod;
            }
            prev = curr;
        }
        return prev[amount];
    }

    public int method2(int[] coins, int N, int amount) {
        int[][] dp = new int[N][amount + 1];
        for (int ind = 0; ind < N; ind++) {
            dp[ind][0] = 1;
        }

        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0)
                dp[0][amt] = 1;
        }

        for (int ind = 1; ind < N; ind++) {
            for (int amt = 1; amt <= amount; amt++) {
                int left = 0;
                //take case
                if (amt >= coins[ind])
                    left = dp[ind][amt - coins[ind]];
                //not take case
                int right = dp[ind - 1][amt];
                dp[ind][amt] = (left + right) % mod;
            }
        }
        return dp[N - 1][amount];
    }

    public int method1(int[] coins, int N, int amount) {
        int[][] dp = new int[N][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return count(N - 1, amount, coins, dp);
    }

    int count(int ind, int target, int[] coins, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (ind == 0) {
            if (target % coins[0] == 0)
                return 1;
            return 0;
        }
        if (dp[ind][target] != -1)
            return dp[ind][target];
        int left = 0;
        //take case
        if (target >= coins[ind])
            left = count(ind, target - coins[ind], coins, dp);
        //not take case
        int right = count(ind - 1, target, coins, dp);
        return dp[ind][target] = (left + right) % mod;
    }

    public static void main(String[] args) {
        int[] coins = {2, 4, 10};
        int amount = 10;
        CoinChangeII obj = new CoinChangeII();
        System.out.println(obj.method1(coins, coins.length, amount));
        System.out.println(obj.method2(coins, coins.length, amount));
        System.out.println(obj.count(coins, coins.length, amount));
    }
}
