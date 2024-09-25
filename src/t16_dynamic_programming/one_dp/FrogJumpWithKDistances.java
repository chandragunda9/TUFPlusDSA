package t16_dynamic_programming.one_dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FrogJumpWithKDistances {
    public int method1(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(heights, n - 1, k, dp);
    }

    int solve(int[] heights, int ind, int k, int[] dp) {
        if (ind == 0)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int minEnergy = Integer.MAX_VALUE;
        for (int step = 1; step <= k; step++) {
            int energy;
            if (step <= ind) {
                energy = Math.abs(heights[ind] - heights[ind - step]) + solve(heights, ind - step, k, dp);
            } else
                break;
            minEnergy = Math.min(minEnergy, energy);
        }
        return dp[ind] = minEnergy;
    }

    public int frogJump(int[] heights, int k) {
        List<Integer> dp = new ArrayList<>(Collections.nCopies(k, 0));
        dp.set(0, 0);
        int n = heights.length;
        for (int i = 1; i < n; i++) {
            int curr = Integer.MAX_VALUE;
            for (int kthStep = 1; kthStep <= k; kthStep++) {
                if (i >= kthStep) {
                    curr = Math.min(curr,
                            Math.abs(heights[i] - heights[i - kthStep]) + dp.get(k - kthStep));
                } else {
                    break;
                }
            }
            dp.remove(0);
            dp.add(curr);
        }
        return dp.get(k - 1);
    }

    public int method2(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minEnergy = Integer.MAX_VALUE;
            for (int kthStep = 1; kthStep <= k; kthStep++) {
                if (i >= kthStep) {
                    minEnergy = Math.min(minEnergy, dp[i - kthStep] + Math.abs(heights[i] - heights[i - kthStep]));
                } else
                    break;
            }
            dp[i] = minEnergy;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] heights = {10, 5, 20, 0, 15};
        int k = 2;
        FrogJumpWithKDistances obj = new FrogJumpWithKDistances();
        System.out.println(obj.method1(heights, k));
        System.out.println(obj.method2(heights, k));
        System.out.println(obj.frogJump(heights, k));
    }
}
