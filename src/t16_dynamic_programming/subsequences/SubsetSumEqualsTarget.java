package t16_dynamic_programming.subsequences;

import java.util.Arrays;

public class SubsetSumEqualsTarget {
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[] prev = new boolean[target + 1];
        //base cases
        prev[0] = true;
        if (arr[0] <= target)
            prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for (int t = 1; t <= target; t++) {
                //take case
                boolean take = false;
                if (t >= arr[ind])
                    take = prev[t - arr[ind]];
                //not take case
                boolean notTake = prev[t];
                curr[t] = take || notTake;
            }
            prev = curr;
        }

        return prev[target];
    }

    public boolean method2(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];
        //base cases
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= target)
            dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int t = 1; t <= target; t++) {
                //take case
                boolean take = false;
                if (t >= arr[ind])
                    take = dp[ind - 1][t - arr[ind]];
                //not take case
                boolean notTake = dp[ind - 1][t];
                dp[ind][t] = take || notTake;
            }
        }

        return dp[n - 1][target];
    }

    public boolean method1(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return solveRec(arr.length - 1, arr, target, dp);
    }

    boolean solveRec(int ind, int[] arr, int target, int[][] dp) {
        if (target == 0)
            return true;
        if (ind == 0)
            return arr[0] == target;
        if (dp[ind][target] != -1) {
            return dp[ind][target] == 1;
        }
        //take case
        boolean take = false;
        if (target >= arr[ind])
            take = solveRec(ind - 1, arr, target - arr[ind], dp);
        boolean notTake = solveRec(ind - 1, arr, target, dp);
        dp[ind][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        int target = 8;
        SubsetSumEqualsTarget obj = new SubsetSumEqualsTarget();
        System.out.println(obj.method1(arr, target));
        System.out.println(obj.method2(arr, target));
        System.out.println(obj.isSubsetSum(arr, target));
    }
}
