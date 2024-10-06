package t16_dynamic_programming.mcm_dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumCostToCutTheStick {
    public int minCost(int n, List<Integer> cuts) {
        int c = cuts.size();
        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);

        int[][] dp = new int[c + 2][c + 2];
//        in recursion
//        i -> 1 to c
//        j -> 1 to c
//         so do in opposite way
        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j)
                    continue;
                int minVal = Integer.MAX_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int val = cuts.get(j + 1) - cuts.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];
                    minVal = Math.min(minVal, val);
                }
                dp[i][j] = minVal;
            }
        }
        return dp[1][c];
    }

    public int method1(int n, List<Integer> cuts) {
        int c = cuts.size();
        cuts.add(0, 0);
        cuts.add(n);
        Collections.sort(cuts);
        int[][] dp = new int[c + 1][c + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(1, c, cuts, dp);
    }

    int solve(int i, int j, List<Integer> cuts, int[][] dp) {
        if (j < i)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int minVal = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int len = cuts.get(j + 1) - cuts.get(i - 1);
            int val = len + solve(i, ind - 1, cuts, dp) + solve(ind + 1, j, cuts, dp);
            minVal = Math.min(minVal, val);
        }
        return dp[i][j] = minVal;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] cuts = {1, 3, 4, 5};
        ArrayList<Integer> li = Arrays.stream(cuts).boxed().collect(Collectors.toCollection(ArrayList::new));
        MinimumCostToCutTheStick obj = new MinimumCostToCutTheStick();
        System.out.println(obj.method1(n, li));
        System.out.println(obj.minCost(n, li));
    }
}
