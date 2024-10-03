package t16_dynamic_programming.subsequences;

import java.util.Arrays;

public class PartitionSubsetAbsoluteDifference {
    public int method2(int[] arr, int n) {
        int targetSum = 0;
        for (int i = 0; i < n; i++) {
            targetSum += arr[i];
        }
        boolean[][] dp = new boolean[n][targetSum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= targetSum)
            dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int t = 1; t <= targetSum; t++) {
                boolean left = false;
                if (t >= arr[ind])
                    left = dp[ind - 1][t - arr[ind]];
                boolean right = dp[ind - 1][t];
                dp[ind][t] = left || right;
            }
        }
        int minDiff = targetSum;
        for (int i = 0; i <= targetSum / 2; i++) {
            int s1 = i, s2 = targetSum - i;
            if (dp[n - 1][s1]) {
                minDiff = Math.min(minDiff, Math.abs(s1 - s2));
            }
        }
        return minDiff;
    }

    public int method1(int[] arr, int n) {
        int targetSum = 0;
        for (int i = 0; i < n; i++) {
            targetSum += arr[i];
        }
        int[][] dp = new int[n][targetSum + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int t = 0; t <= targetSum; t++) {
            solve(n - 1, t, arr, dp);
        }

        int minDiff = targetSum;
        for (int i = 0; i <= targetSum / 2; i++) {
            int s1 = i, s2 = targetSum - i;
            if (dp[n - 1][s1] == 1) {
                minDiff = Math.min(minDiff, Math.abs(s1 - s2));
            }
        }
        return minDiff;
    }

    boolean solve(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (ind == 0) {
            return target == arr[0];
        }
        if (dp[ind][target] != -1)
            return dp[ind][target] == 1;
        boolean left = false;
        if (target >= arr[ind])
            left = solve(ind - 1, target - arr[ind], arr, dp);
        boolean right = solve(ind - 1, target, arr, dp);
        if (left || right) {
            dp[ind][target] = 1;
        } else {
            dp[ind][target] = 0;
        }
        return left || right;
    }

    public int minDifference(int[] arr, int n) {
        int targetSum = 0;
        for (int i = 0; i < n; i++) {
            targetSum += arr[i];
        }
        boolean[] prev = new boolean[targetSum + 1];

        prev[0] = true;
        if (arr[0] <= targetSum)
            prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean[] curr = new boolean[targetSum + 1];
            curr[0] = true;
            for (int t = 1; t <= targetSum; t++) {
                boolean left = false;
                if (t >= arr[ind])
                    left = prev[t - arr[ind]];
                boolean right = prev[t];
                curr[t] = left || right;
            }
            prev = curr;
        }
        int minDiff = targetSum;
        for (int i = 0; i <= targetSum / 2; i++) {
            int s1 = i, s2 = targetSum - i;
            if (prev[s1]) {
                minDiff = Math.min(minDiff, Math.abs(s1 - s2));
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 14, 5};
        PartitionSubsetAbsoluteDifference obj = new PartitionSubsetAbsoluteDifference();
        System.out.println(obj.method1(arr, arr.length));
        System.out.println(obj.method2(arr, arr.length));
        System.out.println(obj.minDifference(arr, arr.length));
    }
}
