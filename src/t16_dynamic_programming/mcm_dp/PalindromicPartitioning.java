package t16_dynamic_programming.mcm_dp;

import java.util.Arrays;

public class PalindromicPartitioning {
    int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int minPartitions = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                    int p = 1 + dp[j + 1];
                    minPartitions = Math.min(minPartitions, p);
                }
            }
            dp[i] = minPartitions;
        }
        return dp[0] - 1;
    }

    int method1(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, n, s, dp) - 1;
    }

    int solve(int i, int n, String s, int[] dp) {
        if (i == n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int minPartitions = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, s)) {
                int p = 1 + solve(j + 1, n, s, dp);
                minPartitions = Math.min(minPartitions, p);
            }
        }
        return dp[i] = minPartitions;
    }

    boolean isPalindrome(int i, int j, String st) {
        while (i < j) {
            if (st.charAt(i++) != st.charAt(j--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        PalindromicPartitioning obj = new PalindromicPartitioning();
        System.out.println(obj.method1(s));
        System.out.println(obj.minCut(s));
    }
}
