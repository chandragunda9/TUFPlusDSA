package t16_dynamic_programming.strings;

import java.util.Arrays;

public class WildCardMatching {
    public boolean wildCard(String str, String pat) {
        return false;
    }

    public boolean method3(String str, String pat) {
        int n = pat.length(), m = str.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        //base cases
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }

//        for (int i = 1; i <= n; i++) {
//            boolean flag = true;
//            //checking if all chars * up to <i
//            for (int k = 0; k < i; k++) {
//                if (pat.charAt(k) != '*') {
//                    flag = false;
//                    break;
//                }
//            }
//            dp[i][0] = flag;
//        }

        for (int i = 1; i <= n; i++) {
            //checking if all chars * up to <i
            dp[i][0] = pat.charAt(i - 1) == '*' && dp[i - 1][0];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char ch1 = pat.charAt(i - 1);
                char ch2 = str.charAt(j - 1);
                if (ch1 == ch2 || ch1 == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (ch1 == '*') {
                    //0 characters
                    boolean left = dp[i - 1][j];
                    //single character
                    boolean right = dp[i][j - 1];
                    dp[i][j] = left || right;
                }
            }
        }
        return dp[n][m];
    }

    public boolean method2(String str, String pat) {
        int n = pat.length(), m = str.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solveMem(n, m, pat, str, dp);
    }

    boolean solveMem(int i, int j, String pat, String str, int[][] dp) {
        if (i == 0 && j == 0)
            return true;
        if (i == 0)
            return false;
        if (j == 0) {
            //checking if all chars * up to <i
            for (int k = 0; k < i; k++) {
                if (pat.charAt(k) != '*')
                    return false;
            }
            return true;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        char ch1 = pat.charAt(i - 1);
        char ch2 = str.charAt(j - 1);
        boolean res = false;
        if (ch1 == ch2 || ch1 == '?') {
            res = solveMem(i - 1, j - 1, pat, str, dp);
        } else if (ch1 == '*') {
            //0 characters
            boolean left = solveMem(i - 1, j, pat, str, dp);
            //single character
            boolean right = solveMem(i, j - 1, pat, str, dp);
            res = left || right;
        }
        dp[i][j] = res ? 1 : 0;
        return res;
    }

    public boolean method1(String str, String pat) {
        int n = pat.length(), m = str.length();
        return solve(n - 1, m - 1, pat, str);
    }

    boolean solve(int i, int j, String pat, String str) {
        if (i < 0 && j < 0)
            return true;
        if (i < 0) //if (i<0 && j>=0)
            return false;
        if (j < 0) {
            for (int k = 0; k <= i; k++) {
                if (pat.charAt(k) != '*')
                    return false;
            }
            return true;
        }
        char ch1 = pat.charAt(i);
        char ch2 = str.charAt(j);
        if (ch1 == ch2 || ch1 == '?')
            return solve(i - 1, j - 1, pat, str);
        if (ch1 == '*') {
            //0 characters
            boolean left = solve(i - 1, j, pat, str);
            //single character
            boolean right = solve(i, j - 1, pat, str);
            return left || right;
        }
        return false;
    }

    public static void main(String[] args) {
//        String str = "xaylmz", pat = "x?y*z";
//        String str = "xyza", pat = "x*z";
        String pat = "****a***b**c", str = "dsfsabc";
        WildCardMatching obj = new WildCardMatching();
        System.out.println(obj.method1(str, pat));
        System.out.println(obj.method2(str, pat));
        System.out.println(obj.method3(str, pat));
    }
}
