package t16_dynamic_programming.subsequences;

import java.util.Arrays;

public class TargetSum {
    int mod = (int) (1e9 + 7);

    public int targetSum(int n, int target, int[] nums) {
        return 0;
    }

    public int method1(int n, int target, int[] nums) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (((sum + target) & 1) != 0) {
            return 0;
        }
        int newTarget = (sum + target) / 2;
        int[][] dp = new int[n][newTarget + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return count(n - 1, newTarget, nums, dp);
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
        int[] nums = {1, 2, 7, 1, 5};
        int target = 4;
        TargetSum obj = new TargetSum();
        System.out.println(obj.method1(nums.length, target, nums));
    }
}
