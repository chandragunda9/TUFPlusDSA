package t16_dynamic_programming.stocks;

import java.util.Arrays;

public class BuyAndSellStockIV {
    public int stockBuySell(int[] arr, int n, int k) {
        int[][] next = new int[2][k + 1];
        for (int day = n - 1; day >= 0; day--) {
            int[][] curr = new int[2][k + 1];
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int cap = 1; cap <= k; cap++) {
                    int profit = 0;
                    if (canBuy == 1) {
                        int buyCase = -arr[day] + next[0][cap];
                        int notBuyCase = next[1][cap];
                        profit = Math.max(buyCase, notBuyCase);
                    }
                    if (canBuy == 0) {
                        int sellCase = arr[day] + next[1][cap - 1];
                        int notSellCase = next[0][cap];
                        profit = Math.max(sellCase, notSellCase);
                    }
                    curr[canBuy][cap] = profit;
                }
            }
            next = curr;
        }
        return next[1][k];
    }

    public int method1(int[] arr, int n, int k) {
        int[][][] dp = new int[n][2][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solveRec(arr, 0, 1, k, dp);
    }

    int solveRec(int[] arr, int day, int canBuy, int cap, int[][][] dp) {
        if (day == arr.length || cap == 0)
            return 0;
        if (dp[day][canBuy][cap] != -1)
            return dp[day][canBuy][cap];
        int profit = 0;
        if (canBuy == 1) {
            int buyCase = -arr[day] + solveRec(arr, day + 1, 0, cap, dp);
            int notBuyCase = solveRec(arr, day + 1, 1, cap, dp);
            profit = Math.max(buyCase, notBuyCase);
        }
        if (canBuy == 0) {
            int sellCase = arr[day] + solveRec(arr, day + 1, 1, cap - 1, dp);
            int notSellCase = solveRec(arr, day + 1, 0, cap, dp);
            profit = Math.max(sellCase, notSellCase);
        }
        return dp[day][canBuy][cap] = profit;
    }

    public int method2(int[] arr, int n, int k) {
        int[][][] dp = new int[n + 1][2][k + 1];
        for (int day = n - 1; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int cap = 1; cap <= k; cap++) {
                    int profit = 0;
                    if (canBuy == 1) {
                        int buyCase = -arr[day] + dp[day + 1][0][cap];
                        int notBuyCase = dp[day + 1][1][cap];
                        profit = Math.max(buyCase, notBuyCase);
                    }
                    if (canBuy == 0) {
                        int sellCase = arr[day] + dp[day + 1][1][cap - 1];
                        int notSellCase = dp[day + 1][0][cap];
                        profit = Math.max(sellCase, notSellCase);
                    }
                    dp[day][canBuy][cap] = profit;
                }
            }
        }
        return dp[0][1][k];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 5, 0, 3};
        int k = 2;
        BuyAndSellStockIV obj = new BuyAndSellStockIV();
        System.out.println(obj.method1(arr, arr.length, k));
        System.out.println(obj.method2(arr, arr.length, k));
        System.out.println(obj.stockBuySell(arr, arr.length, k));
    }
}
