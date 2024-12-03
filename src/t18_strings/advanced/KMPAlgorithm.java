package t18_strings.advanced;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {
    public List<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        String str = pat + "$" + txt;
        int patLen = pat.length();
//        int[] LPS = computeLPSBrute(str);
        int[] LPS = computeLPSOptimal(str);
        for (int i = patLen + 1; i < str.length(); i++) {
            if (LPS[i] == patLen)
                ans.add(i - 2 * patLen);
        }
        return ans;
    }

    int[] computeLPSBrute(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            for (int len = 1; len <= i; len++) {
                if (s.substring(0, len).equals(s.substring(i - len + 1, i + 1))) {
                    lps[i] = len;
                }
            }
        }
        return lps;
    }

    int[] computeLPSOptimal(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i = 1, j = 0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                while (j > 0 && s.charAt(j) != s.charAt(i)) {
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
        String s = "abracadabra";
        String pat = "abra";
        KMPAlgorithm obj = new KMPAlgorithm();
        System.out.println(obj.search(pat, s));
    }
}
