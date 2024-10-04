package t16_dynamic_programming.strings;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public int longestPalinSubseq(String s) {
        int n = s.length();
        String revS = new StringBuilder(s).reverse().toString();
        int[] prev = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                char ch1 = s.charAt(i - 1);
                char ch2 = revS.charAt(j - 1);
                if (ch1 == ch2) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    int left = curr[j - 1];
                    int right = prev[j];
                    curr[j] = Math.max(left, right);
                }
            }
            prev = curr;
        }
        return prev[n];
    }

    public int method2(String s) {
        int n = s.length();
        String revS = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                char ch1 = s.charAt(i - 1);
                char ch2 = revS.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int left = dp[i][j - 1];
                    int right = dp[i - 1][j];
                    dp[i][j] = Math.max(left, right);
                }
            }
        }
        return dp[n][n];
    }

    public int method1(String s) {
        int n = s.length();
//        String revS = reverse(0, n - 1, s);
        String revS = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n, n, s, revS, dp);
    }

    int solve(int ind1, int ind2, String s1, String s2, int[][] dp) {
        if (ind1 == 0 || ind2 == 0)
            return 0;
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        char ch1 = s1.charAt(ind1 - 1);
        char ch2 = s2.charAt(ind2 - 1);
        if (ch1 == ch2) {
            return 1 + solve(ind1 - 1, ind2 - 1, s1, s2, dp);
        }
        int left = solve(ind1, ind2 - 1, s1, s2, dp);
        int right = solve(ind1 - 1, ind2, s1, s2, dp);
        return dp[ind1][ind2] = Math.max(left, right);
    }

    public String reverse(int i, int j, String s) {
        char[] letters = s.toCharArray();
        while (i < j) {
            char ch = letters[i];
            letters[i] = letters[j];
            letters[j] = ch;
            i++;
            j--;
        }
        return Arrays.toString(letters);
    }
}
