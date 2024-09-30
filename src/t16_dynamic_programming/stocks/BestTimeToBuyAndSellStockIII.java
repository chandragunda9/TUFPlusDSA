package t16_dynamic_programming.stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIII {
    public int stockBuySell(int[] arr, int n) {
        int[][] next = new int[2][3];
        int[][] curr = new int[2][3];
        for (int day = n - 1; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    int profit = 0;
                    if (canBuy == 1) {
                        int buyCase = -arr[day] + next[0][cap];
                        int notBuyCase = next[1][cap];
                        profit = Math.max(buyCase, notBuyCase);
                    } else {
                        int sellCase = arr[day] + next[1][cap - 1];
                        int notSellCase = next[0][cap];
                        profit = Math.max(sellCase, notSellCase);
                    }
                    curr[canBuy][cap] = profit;
                }
            }
            next = curr;
        }
        return next[1][2];
    }

    public int method1(int[] arr, int n) {
        int[][][] dp = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int[] ar : dp[i]) {
                Arrays.fill(ar, -1);
            }
        }
        return solveMem(arr, 0, 1, 2, dp);
    }

    int solveMem(int[] arr, int day, int canBuy, int cap, int[][][] dp) {
        if (cap == 0 || day == arr.length)
            return 0;
        if (dp[day][canBuy][cap] != -1)
            return dp[day][canBuy][cap];
        int profit = 0;
        if (canBuy == 1) {
            int buyCase = -arr[day] + solveMem(arr, day + 1, 0, cap, dp);
            int notBuyCase = solveMem(arr, day + 1, 1, cap, dp);
            profit = Math.max(buyCase, notBuyCase);
        } else {
            int sellCase = arr[day] + solveMem(arr, day + 1, 1, cap - 1, dp);
            int notSellCase = solveMem(arr, day + 1, 0, cap, dp);
            profit = Math.max(sellCase, notSellCase);
        }
        return dp[day][canBuy][cap] = profit;
    }

    public int method2(int[] arr, int n) {
        int[][][] dp = new int[n + 1][2][3];
        for (int day = n - 1; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    int profit = 0;
                    if (canBuy == 1) {
                        int buyCase = -arr[day] + dp[day + 1][0][cap];
                        int notBuyCase = dp[day + 1][1][cap];
                        profit = Math.max(buyCase, notBuyCase);
                    } else {
                        int sellCase = arr[day] + dp[day + 1][1][cap - 1];
                        int notSellCase = dp[day + 1][0][cap];
                        profit = Math.max(sellCase, notSellCase);
                    }
                    dp[day][canBuy][cap] = profit;
                }
            }
        }
        return dp[0][1][2];
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 11, 5};
        BestTimeToBuyAndSellStockIII obj = new BestTimeToBuyAndSellStockIII();
        System.out.println(obj.method1(arr, arr.length));
        System.out.println(obj.method2(arr, arr.length));
        System.out.println(obj.stockBuySell(arr, arr.length));
    }
}
