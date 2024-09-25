package t16_dynamic_programming.one_dp;

import java.util.Arrays;

public class MaximumSum {
    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int takeCase = nums[i] + prev2;
            int notTakeCase = prev;
            int curr = Math.max(takeCase, notTakeCase);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public int method2(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int ind = 2;
        while (ind < n) {
            //take case
            int lSum = nums[ind] + dp[ind - 2];
            //not take case
            int rSum = dp[ind - 1];
            dp[ind] = Math.max(lSum, rSum);
            ind++;
        }
        return dp[n - 1];
    }

    public int method1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, 0, dp);
    }

    int solve(int[] nums, int ind, int[] dp) {
        if (ind >= nums.length) {
            return 0;
        }
        if (dp[ind] != -1)
            return dp[ind];
        //take case
        int lSum = nums[ind] + solve(nums, ind + 2, dp);
        //not take case
        int rSum = solve(nums, ind + 1, dp);
        return dp[ind] = Math.max(lSum, rSum);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        MaximumSum obj = new MaximumSum();
        System.out.println(obj.method1(arr));
        System.out.println(obj.method2(arr));
        System.out.println(obj.nonAdjacent(arr));
    }
}