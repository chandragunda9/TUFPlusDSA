package t16_dynamic_programming.subsequences;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public boolean method1(int n, int[] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if ((sum & 1) != 0)
            return false;
        return solve(n - 1, sum / 2, arr);
    }

    boolean solve(int ind, int target, int[] arr) {
        if (target == 0) {
            return true;
        }
        if (ind == 0) {
            return arr[0] == target;
        }
        //take case
        boolean left = solve(ind - 1, target - arr[ind], arr);
        if (left)
            return true;
        //not take case
        boolean right = solve(ind - 1, target, arr);
        return right;
    }

    //By using Memoization
    public int method2(int n, int[] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if ((sum & 1) != 0)
            return 0;
        int[][] dp = new int[n][sum / 2 + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveMem(n - 1, sum / 2, arr, dp) ? 1 : 0;
    }

    public boolean solveMem(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0)
            return true;
        if (ind == 0)
            return target == arr[0];
        if (dp[ind][target] != -1)
            return dp[ind][target] == 1;
        boolean left = false;
        if (target >= arr[ind])
            left = solveMem(ind - 1, target - arr[ind], arr, dp);
        boolean right = solveMem(ind - 1, target, arr, dp);
        if (left || right) {
            dp[ind][target] = 1;
        } else {
            dp[ind][target] = 0;
        }
        return left || right;
    }

    //By using tabulation
    public int method3(int n, int[] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if ((sum & 1) != 0)
            return 0;
        int target = sum / 2;
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= target)
            dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int t = 1; t <= target; t++) {
                boolean left = false;
                if (t >= arr[ind])
                    left = dp[ind - 1][t - arr[ind]];
                boolean right = dp[ind - 1][t];
                dp[ind][t] = left || right;
            }
        }
        return dp[n - 1][target] ? 1 : 0;
    }

    //space optimization
    public int equalPartition(int n, int[] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if ((sum & 1) != 0)
            return 0;
        int target = sum / 2;
        boolean[] prev = new boolean[target + 1];

        prev[0] = true;

        if (arr[0] <= target)
            prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for (int t = 1; t <= target; t++) {
                boolean left = false;
                if (t >= arr[ind])
                    left = prev[t - arr[ind]];
                boolean right = prev[t];
                curr[t] = left || right;
            }
            prev = curr;
        }
        return prev[target] ? 1 : 0;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 10, 21, 10};
        int[] arr = {1, 2, 3, 5};
        PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
        System.out.println(obj.method1(arr.length, arr));
        System.out.println(obj.method2(arr.length, arr));
        System.out.println(obj.method3(arr.length, arr));
        System.out.println(obj.equalPartition(arr.length, arr));
    }
}
