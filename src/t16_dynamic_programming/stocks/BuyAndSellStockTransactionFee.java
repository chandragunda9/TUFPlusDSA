package t16_dynamic_programming.stocks;

import java.util.Arrays;

public class BuyAndSellStockTransactionFee {
    public int stockBuySell(int[] arr, int n, int fee) {
        int[] next = new int[2], curr = new int[2];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                int profit = 0;
                if (canBuy == 1) {
                    profit = Math.max(profit, Math.max(-arr[ind] + next[0],
                            next[1]));
                } else {
                    profit = Math.max(profit, Math.max(arr[ind] - fee + next[1],
                            next[0]));
                }
                curr[canBuy] = profit;
            }
            next = curr;
        }
        return curr[1];
    }

    public int method1(int[] arr, int n, int fee) {
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveMem(0, arr, 1, fee, dp);
    }

    int solveMem(int ind, int[] prices, int canBuy, int fee, int[][] dp) {
        if (ind == prices.length)
            return 0;
        if (dp[ind][canBuy] != -1)
            return dp[ind][canBuy];
        int profit = 0;
        if (canBuy == 1) {
            //buy case
            int buyCase = -prices[ind] + solveMem(ind + 1, prices, 0, fee, dp);
            //not buy case
            int notBuyCase = solveMem(ind + 1, prices, 1, fee, dp);
            profit = Math.max(profit, Math.max(buyCase, notBuyCase));
        } else {
            //sell case
            int sellCase = prices[ind] - fee + solveMem(ind + 1, prices, 1, fee, dp);
            //not sell case
            int notSellCase = solveMem(ind + 1, prices, 0, fee, dp);
            profit = Math.max(profit, Math.max(sellCase, notSellCase));
        }
        return dp[ind][canBuy] = profit;
    }


    public int method2(int[] arr, int n, int fee) {
        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                int profit = 0;
                if (canBuy == 1) {
                    //buy case
                    int buyCase = -arr[ind] + dp[ind + 1][0];
                    //not buy case
                    int notBuyCase = dp[ind + 1][1];
                    profit = Math.max(profit, Math.max(buyCase, notBuyCase));
                } else {
                    //sell case
                    int sellCase = arr[ind] - fee + dp[ind + 1][1];
                    //not sell case
                    int notSellCase = dp[ind + 1][0];
                    profit = Math.max(profit, Math.max(sellCase, notSellCase));
                }
                dp[ind][canBuy] = profit;
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        BuyAndSellStockTransactionFee obj = new BuyAndSellStockTransactionFee();
        System.out.println(obj.method1(arr, arr.length, fee));
        System.out.println(obj.method2(arr, arr.length, fee));
        System.out.println(obj.stockBuySell(arr, arr.length, fee));
    }
}
