package t16_dynamic_programming.strings;

public class MinimumInsertions {
    public int minInsertion(String s) {
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
        return s.length() - prev[n];
    }
}
