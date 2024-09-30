package t16_dynamic_programming.stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {
    public int stockBuySell(int[] arr, int n) {
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }

    public int method1(int[] arr, int n) {
        return solveRec(0, arr, true);
    }

    int solveRec(int ind, int[] prices, boolean canBuy) {
        if (ind == prices.length)
            return 0;
        int profit = 0;
        if (canBuy) {
            //buy case
            int buyCase = -prices[ind] + solveRec(ind + 1, prices, false);
            //not buy case
            int notBuyCase = solveRec(ind + 1, prices, true);
            profit = Math.max(profit, Math.max(buyCase, notBuyCase));
        } else {
            //sell case
            int sellCase = prices[ind] + solveRec(ind + 1, prices, true);
            //not sell case
            int notSellCase = solveRec(ind + 1, prices, false);
            profit = Math.max(profit, Math.max(sellCase, notSellCase));
        }
        return profit;
    }

    //Tabulation
    public int method3(int[] arr, int n) {
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
                    int sellCase = arr[ind] + dp[ind + 1][1];
                    //not sell case
                    int notSellCase = dp[ind + 1][0];
                    profit = Math.max(profit, Math.max(sellCase, notSellCase));
                }
                dp[ind][canBuy] = profit;
            }
        }
        return dp[0][1];
    }

    public int method4(int[] arr, int n) {
        int[] next = new int[2], curr = new int[2];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                int profit = 0;
                if (canBuy == 1) {
                    profit = Math.max(profit, Math.max(-arr[ind] + next[0],
                            next[1]));
                } else {
                    profit = Math.max(profit, Math.max(arr[ind] + next[1],
                            next[0]));
                }
                curr[canBuy] = profit;
            }
            next = curr;
        }
        return curr[1];
    }


    public int method2(int[] arr, int n) {
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveMem(0, arr, 1, dp);
    }


    int solveMem(int ind, int[] prices, int canBuy, int[][] dp) {
        if (ind == prices.length)
            return 0;
        if (dp[ind][canBuy] != -1)
            return dp[ind][canBuy];
        int profit = 0;
        if (canBuy == 1) {
            //buy case
            int buyCase = -prices[ind] + solveMem(ind + 1, prices, 0, dp);
            //not buy case
            int notBuyCase = solveMem(ind + 1, prices, 1, dp);
            profit = Math.max(profit, Math.max(buyCase, notBuyCase));
        } else {
            //sell case
            int sellCase = prices[ind] + solveMem(ind + 1, prices, 1, dp);
            //not sell case
            int notSellCase = solveMem(ind + 1, prices, 0, dp);
            profit = Math.max(profit, Math.max(sellCase, notSellCase));
        }
        return dp[ind][canBuy] = profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII obj = new BestTimeToBuyAndSellStockII();
        int[] arr = {2, 3, 4, 5, 6};
        System.out.println(obj.method1(arr, arr.length));
        System.out.println(obj.method2(arr, arr.length));
        System.out.println(obj.method3(arr, arr.length));
        System.out.println(obj.method4(arr, arr.length));
        System.out.println(obj.stockBuySell(arr, arr.length));
    }
}
