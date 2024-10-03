package t16_dynamic_programming.subsequences;

import java.util.Arrays;

public class CountSubsetsWithSumK {
    int mod = (int) (1e9 + 7);

    public int perfectSum(int[] arr, int K) {
        int n = arr.length;
        int[] prev = new int[K + 1];
        prev[0] = 1;
        if (K >= arr[0])
            prev[arr[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[K + 1];
            curr[0] = 1;
            for (int t = 1; t <= K; t++) {
                //take case
                int left = 0;
                if (t >= arr[ind])
                    left = prev[t - arr[ind]];
                //not take case
                int right = prev[t];
                curr[t] = (left + right) % mod;
            }
            prev = curr;
        }
        return prev[K];
    }

    public int method2(int[] arr, int K) {
        int n = arr.length;
        int[][] dp = new int[n][K + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        if (K >= arr[0])
            dp[0][arr[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            for (int t = 1; t <= K; t++) {
                //take case
                int left = 0;
                if (t >= arr[ind])
                    left = dp[ind - 1][t - arr[ind]];
                //not take case
                int right = dp[ind - 1][t];
                dp[ind][t] = (left + right) % mod;
            }
        }
        return dp[n - 1][K];
    }

    public int method1(int[] arr, int K) {
        int n = arr.length;
        int[][] dp = new int[n][K + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return countMem(n - 1, K, arr, dp);
    }

    int countMem(int ind, int k, int[] arr, int[][] dp) {
        if (k == 0)
            return 1;
        if (ind == 0) {
            if (k == arr[0])
                return 1;
            return 0;
        }
        if (dp[ind][k] != -1)
            return dp[ind][k];
        //take case
        int left = 0;
        if (k >= arr[ind])
            left = countMem(ind - 1, k - arr[ind], arr, dp);
        //not take case
        int right = countMem(ind - 1, k, arr, dp);
        return dp[ind][k] = (left + right) % mod;
    }

    public static void main(String[] args) {
//        int[] arr = {2, 3, 5, 16, 8, 10};
//        int k = 10;
        int[] arr = {1, 2, 3, 4, 5};
        int k = 5;
        CountSubsetsWithSumK obj = new CountSubsetsWithSumK();
        System.out.println(obj.method1(arr, k));
        System.out.println(obj.method2(arr, k));
        System.out.println(obj.perfectSum(arr, k));
    }
}
