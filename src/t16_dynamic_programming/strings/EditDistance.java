package t16_dynamic_programming.strings;

import java.util.Arrays;

public class EditDistance {
    public int editDistance(String start, String target) {
        int n = start.length(), m = target.length();
        int[] prev = new int[m + 1];
        prev[0] = 0;
        for (int j = 1; j <= m; j++) {
            prev[j] = j;
        }
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                char ch1 = start.charAt(i - 1);
                char ch2 = target.charAt(j - 1);
                if (ch1 == ch2) {
                    curr[j] = prev[j - 1];
                } else {
                    //insert
                    int insOp = 1 + curr[j - 1];
                    //delete
                    int delOp = 1 + prev[j];
                    //replace
                    int repOp = 1 + prev[j - 1];
                    curr[j] = Math.min(repOp, Math.min(insOp, delOp));
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    public int method2(String start, String target) {
        int n = start.length(), m = target.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char ch1 = start.charAt(i - 1);
                char ch2 = target.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //insert
                    int insOp = 1 + dp[i][j - 1];
                    //delete
                    int delOp = 1 + dp[i - 1][j];
                    //replace
                    int repOp = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(repOp, Math.min(insOp, delOp));
                }
            }
        }
        return dp[n][m];
    }

    public int method1(String start, String target) {
        int n = start.length(), m = target.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n, m, start, target, dp);
    }

    int solve(int i, int j, String start, String target, int[][] dp) {
        if (j == 0)
            return i;
        if (i == 0)
            return j;
        if (dp[i][j] != -1)
            return dp[i][j];
        char ch1 = start.charAt(i - 1);
        char ch2 = target.charAt(j - 1);
        if (ch1 == ch2) {
            return solve(i - 1, j - 1, start, target, dp);
        }
        //insert
        int insOp = 1 + solve(i, j - 1, start, target, dp);
        //delete
        int delOp = 1 + solve(i - 1, j, start, target, dp);
        //replace
        int repOp = 1 + solve(i - 1, j - 1, start, target, dp);
        return dp[i][j] = Math.min(repOp, Math.min(insOp, delOp));
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        String t = "azced";
        EditDistance obj = new EditDistance();
        System.out.println(obj.method1(s, t));
        System.out.println(obj.method2(s, t));
        System.out.println(obj.editDistance(s, t));
    }
}
