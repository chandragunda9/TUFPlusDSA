package t16_dynamic_programming.strings;

public class LongestCommonSubstring {
    public int longestCommonSubstr(String str1, String str2) {
        int n = str1.length(), m = str2.length(), max = 0;
        int[] prev = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                char ch1 = str1.charAt(i - 1);
                char ch2 = str2.charAt(j - 1);
                if (ch1 == ch2) {
                    curr[j] = 1 + prev[j - 1];
                    max = Math.max(max, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            prev = curr;
        }
        return max;
    }

    public int method1(String str1, String str2) {
        int n = str1.length(), m = str2.length(), max = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char ch1 = str1.charAt(i - 1);
                char ch2 = str2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
