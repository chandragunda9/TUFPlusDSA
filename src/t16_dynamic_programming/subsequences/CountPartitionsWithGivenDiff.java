package t16_dynamic_programming.subsequences;

import java.util.Arrays;

public class CountPartitionsWithGivenDiff {
    int mod = (int) (1e9 + 7);

    public int countPartitions(int n, int diff, int[] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (((sum + diff) & 1) != 0) {
            return 0;
        }
        int target = (sum + diff) / 2;
        int[] prev = new int[target + 1];
        if (arr[0] == 0)
            prev[0] = 2;
        else
            prev[0] = 1;

        if (arr[0] != 0 && target >= arr[0])
            prev[arr[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[target + 1];
            for (int t = 0; t <= target; t++) {
                //take case
                int left = 0;
                if (t >= arr[ind]) {
                    left = prev[t - arr[ind]];
                }
                //not take case
                int right = prev[t];
                curr[t] = (left + right) % mod;
            }
            prev=curr;
        }
        return prev[target];
    }

    public int method2(int n, int diff, int[] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (((sum + diff) & 1) != 0) {
            return 0;
        }
        int target = (sum + diff) / 2;
        int[][] dp = new int[n][target + 1];
        if (arr[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;

        if (arr[0] != 0 && target >= arr[0])
            dp[0][arr[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            for (int t = 0; t <= target; t++) {
                //take case
                int left = 0;
                if (t >= arr[ind]) {
                    left = dp[ind - 1][t - arr[ind]];
                }
                //not take case
                int right = dp[ind - 1][t];
                dp[ind][t] = (left + right) % mod;
            }
        }
        return dp[n - 1][target];
    }

    public int method1(int n, int diff, int[] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (((sum + diff) & 1) != 0) {
            return 0;
        }
        int target = (sum + diff) / 2;
        int[][] dp = new int[n][target + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return count(n - 1, target, arr, dp);
    }

    int count(int ind, int target, int[] arr, int[][] dp) {
        if (ind == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || arr[0] == target)
                return 1;
            return 0;
        }
        if (dp[ind][target] != -1)
            return dp[ind][target];
        //take case
        int left = 0;
        if (target >= arr[ind]) {
            left = count(ind - 1, target - arr[ind], arr, dp);
        }
        //not take case
        int right = count(ind - 1, target, arr, dp);
        return dp[ind][target] = (left + right) % mod;
    }

    public static void main(String[] args) {
        int diff = 3;
        int[] arr = {5, 2, 6, 4};
        CountPartitionsWithGivenDiff obj = new CountPartitionsWithGivenDiff();
        System.out.println(obj.method1(arr.length, diff, arr));
        System.out.println(obj.method2(arr.length, diff, arr));
        System.out.println(obj.countPartitions(arr.length, diff, arr));
    }
}
