package t16_dynamic_programming.strings;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public int lcs(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[] prev = new int[m + 1];

        for (int ind2 = 0; ind2 <= m; ind2++) {
            prev[ind2] = 0;
        }

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                char ch1 = str1.charAt(i - 1);
                char ch2 = str2.charAt(j - 1);
                if (ch1 == ch2) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    int left = prev[j];
                    int right = curr[j - 1];
                    curr[j] = Math.max(left, right);
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    public int method3(String str1, String str2) {
        //Tabulation
        int n1 = str1.length(), n2 = str2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int ind1 = 0; ind1 <= n1; ind1++) {
            dp[ind1][0] = 0;
        }
        for (int ind2 = 0; ind2 <= n2; ind2++) {
            dp[0][ind2] = 0;
        }

        for (int ind1 = 1; ind1 <= n1; ind1++) {
            for (int ind2 = 1; ind2 <= n2; ind2++) {
                char ch1 = str1.charAt(ind1 - 1);
                char ch2 = str2.charAt(ind2 - 1);
                if (ch1 == ch2) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } else {
                    int left = dp[ind1 - 1][ind2];
                    int right = dp[ind1][ind2 - 1];
                    dp[ind1][ind2] = Math.max(left, right);
                }
            }
        }
        return dp[n1][n2];
    }

    public int method2(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solveMem(n1, n2, str1, str2, dp);
    }

    int solveMem(int ind1, int ind2, String str1, String str2, int[][] dp) {
        if (ind1 == 0 || ind2 == 0) {
            return 0;
        }
        char ch1 = str1.charAt(ind1 - 1);
        char ch2 = str2.charAt(ind2 - 1);
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        if (ch1 == ch2) {
            return 1 + solveMem(ind1 - 1, ind2 - 1, str1, str2, dp);
        }
        int left = solveMem(ind1 - 1, ind2, str1, str2, dp);
        int right = solveMem(ind1, ind2 - 1, str1, str2, dp);
        return dp[ind1][ind2] = Math.max(left, right);
    }

//    public int method2(String str1, String str2) {
//        int n1 = str1.length(), n2 = str2.length();
//        int[][] dp = new int[n1][n2];
//        for (int i = 0; i < n1; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return solveMem(n1 - 1, n2 - 1, str1, str2, dp);
//    }
//
//    int solveMem(int ind1, int ind2, String str1, String str2, int[][] dp) {
//        if (ind1 < 0 || ind2 < 0) {
//            return 0;
//        }
//        char ch1 = str1.charAt(ind1);
//        char ch2 = str2.charAt(ind2);
//        if (dp[ind1][ind2] != -1)
//            return dp[ind1][ind2];
//        if (ch1 == ch2) {
//            return 1 + solveMem(ind1 - 1, ind2 - 1, str1, str2, dp);
//        }
//        int left = solveMem(ind1 - 1, ind2, str1, str2, dp);
//        int right = solveMem(ind1, ind2 - 1, str1, str2, dp);
//        return dp[ind1][ind2] = Math.max(left, right);
//    }

    public int method1(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        return solve(n1 - 1, n2 - 1, str1, str2);
    }

    int solve(int ind1, int ind2, String str1, String str2) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }
        char ch1 = str1.charAt(ind1);
        char ch2 = str2.charAt(ind2);
        if (ch1 == ch2) {
            return 1 + solve(ind1 - 1, ind2 - 1, str1, str2);
        }
        int left = solve(ind1 - 1, ind2, str1, str2);
        int right = solve(ind1, ind2 - 1, str1, str2);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        String st1 = "mnop";
        String st2 = "mnq";
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        System.out.println(obj.method1(st1, st2));
        System.out.println(obj.method2(st1, st2));
        System.out.println(obj.method3(st1, st2));
        System.out.println(obj.lcs(st1, st2));
    }
}
