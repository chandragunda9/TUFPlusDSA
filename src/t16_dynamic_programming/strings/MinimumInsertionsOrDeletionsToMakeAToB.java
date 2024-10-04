package t16_dynamic_programming.strings;

public class MinimumInsertionsOrDeletionsToMakeAToB {
    public int minOperations(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int lcsVal = lcs(str1, str2);
        int deletions = n - lcsVal;
        int insertions = m - lcsVal;
        return deletions + insertions;
    }

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
}
