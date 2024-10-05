package t16_dynamic_programming.strings;

import java.util.Arrays;

public class DistinctSubsequences {
    int mod = (int) (1e9 + 7);

    public int distinctSubsequences(String s, String t) {
        int n = s.length(), m = t.length();
        int[] prev = new int[m + 1];

        //base cases
        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = 1;
            for (int j = 1; j <= m; j++) {
                char ch1 = s.charAt(i - 1);
                char ch2 = t.charAt(j - 1);
                int res;
                if (ch1 == ch2) {
                    int leaveOne = prev[j - 1];
                    int stay = prev[j];
                    res = (leaveOne + stay) % mod;
                } else {
                    res = prev[j] % mod;
                }
                curr[j] = res;
            }
            prev = curr;
        }
        return prev[m];
    }

    //Using only one array
    public int distinctSubsequences1(String s, String t) {
        int n = s.length(), m = t.length();
        int[] prev = new int[m + 1];

        //base cases
        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                char ch1 = s.charAt(i - 1);
                char ch2 = t.charAt(j - 1);
                int res;
                if (ch1 == ch2) {
                    int leaveOne = prev[j - 1];
                    int stay = prev[j];
                    res = (leaveOne + stay) % mod;
                } else {
                    res = prev[j] % mod;
                }
                prev[j] = res;
            }
        }
        return prev[m];
    }

    public int method2(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        //base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char ch1 = s.charAt(i - 1);
                char ch2 = t.charAt(j - 1);
                int res;
                if (ch1 == ch2) {
                    int leaveOne = dp[i - 1][j - 1];
                    int stay = dp[i - 1][j];
                    res = (leaveOne + stay) % mod;
                } else {
                    res = dp[i - 1][j];
                }
                dp[i][j] = res;
            }
        }
        return dp[n][m];
    }

    public int method1(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return count(n, m, s, t, dp);
    }

    int count(int i, int j, String s, String t, int[][] dp) {
        if (j == 0)
            return 1;
        if (i == 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        char ch1 = s.charAt(i - 1);
        char ch2 = t.charAt(j - 1);
        int res = 0;
        if (ch1 == ch2) {
            int leaveOne = count(i - 1, j - 1, s, t, dp);
            int stay = count(i - 1, j, s, t, dp);
            res = (leaveOne + stay) % mod;
        } else {
            res = count(i - 1, j, s, t, dp);
        }
        return dp[i][j] = res;
    }

    public static void main(String[] args) {
        String s = "babgbag", t = "bag";
        DistinctSubsequences obj = new DistinctSubsequences();
        System.out.println(obj.method1(s, t));
        System.out.println(obj.method2(s, t));
        System.out.println(obj.distinctSubsequences(s, t));
        System.out.println(obj.distinctSubsequences1(s, t));
    }
}