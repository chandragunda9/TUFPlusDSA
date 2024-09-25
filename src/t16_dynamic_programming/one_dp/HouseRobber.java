package t16_dynamic_programming.one_dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseRobber {
    public int houseRobber(int[] money) {
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        int n = money.length;
        for (int i = 0; i < n; i++) {
            if (i != 0)
                temp1.add(money[i]);
            if (i != n - 1)
                temp2.add(money[i]);
        }
        int[] arr1 = temp1.stream().mapToInt(Integer::intValue).toArray();
        int[] arr2 = temp2.stream().mapToInt(Integer::intValue).toArray();
        return Math.max(solveWithSpaceOptimization(arr1), solveWithSpaceOptimization(arr2));
    }

    public int solveWithSpaceOptimization(int[] money) {
        int n = money.length;
        int prev = money[0];
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int takeCase = money[i] + prev2;
            int notTakeCase = prev;
            int curr = Math.max(takeCase, notTakeCase);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public int method1(int[] money) {
        int n = money.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        //from 0 to n-2
        int first = solve(0, n - 1, money, dp);
        //from 1 to n-1
        Arrays.fill(dp, -1);
        int second = solve(1, n, money, dp);
        return Math.max(first, second);
    }

    public int solve(int ind, int n, int[] money, int[] dp) {
        if (ind >= n)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        //take case
        int lSum = money[ind] + solve(ind + 2, n, money, dp);
        //not take case
        int rSum = solve(ind + 1, n, money, dp);
        return dp[ind] = Math.max(lSum, rSum);
    }

    public int method2(int[] money) {
        int n = money.length;
        if (n == 1)
            return money[0];
        if (n == 2)
            return Math.max(money[0], money[1]);
        return Math.max(solveTab(money, 0, n - 1), solveTab(money, 1, n));
    }

    public int solveTab(int[] money, int start, int n) {
        if (n == 1)
            return money[start];
        int[] dp = new int[n];
        dp[start] = money[start];
        dp[start + 1] = Math.max(money[start], money[start + 1]);
        for (int i = start + 2; i < n; i++) {
            //take case
            int takeAmt = money[i] + dp[i - 2];
            //not take case
            int notTakeAmt = dp[i - 1];
            dp[i] = Math.max(takeAmt, notTakeAmt);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 1, 6};
        HouseRobber obj = new HouseRobber();
        System.out.println(obj.method1(arr));
        System.out.println(obj.method2(arr));
        System.out.println(obj.houseRobber(arr));
    }
}
