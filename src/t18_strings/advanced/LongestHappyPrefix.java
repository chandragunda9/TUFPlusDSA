package t18_strings.advanced;

public class LongestHappyPrefix {
    public String lps(String s) {
        int[] LPS = computeLPS(s);
        return s.substring(0, LPS[s.length() - 1]);
    }

    int[] computeLPS(String s) {
        int n = s.length();
        int i = 1, j = 0;
        int[] lps = new int[n];
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i] = j + 1;
                j++;
                i++;
            } else {
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = lps[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    lps[i] = j + 1;
                    j++;
                }
                i++;
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String s = "aaaa";
        LongestHappyPrefix obj = new LongestHappyPrefix();
        System.out.println(obj.lps(s));
    }
}
