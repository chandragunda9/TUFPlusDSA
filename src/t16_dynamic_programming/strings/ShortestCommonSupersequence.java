package t16_dynamic_programming.strings;

public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        int lcsLen = lcs(str1, str2, dp);
        int shortestCommonSuperSeqLen = n + m - lcsLen;

        //path finding
        StringBuilder ans = new StringBuilder();
        int i = n, j = m, ind = shortestCommonSuperSeqLen - 1;
        while (i > 0 && j > 0) {
            char ch1 = str1.charAt(i - 1);
            char ch2 = str2.charAt(j - 1);
            if (ch1 == ch2) {
                ans.append(ch1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(ch1);
                i--;
            } else {
                ans.append(ch2);
                j--;
            }
            ind--;
        }

        while (i > 0) {
            ans.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            ans.append(str2.charAt(j - 1));
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public int lcs(String str1, String str2, int[][] dp) {
        //Tabulation
        int n1 = str1.length(), n2 = str2.length();
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

    public static void main(String[] args) {
        String str1 = "dynamic", str2 = "program";
        ShortestCommonSupersequence obj = new ShortestCommonSupersequence();
        System.out.println(obj.shortestCommonSupersequence(str1, str2));
    }
}
