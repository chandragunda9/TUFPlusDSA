package t10_two_pointers_sliding_window.longest_smallest_window_problems;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        int l = 0, r = 0, n = s.length(), m = t.length(), minLen = Integer.MAX_VALUE, startIndex = -1;
        int[] freq = new int[256];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }
        int count = 0;
        while (r < n) {
            char ch = s.charAt(r);
            if (freq[ch] > 0) {
                count++;
            }
            freq[ch]--;
            while (count == m) {
                if ((r - l + 1) < minLen) {
                    minLen = (r - l + 1);
                    startIndex = l;
                }
                char leftCh = s.charAt(l);
                freq[leftCh]++;
                if (freq[leftCh] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }

    public static String method1(String s, String t) {
        int n = s.length(), minLen = Integer.MAX_VALUE, startIndex = -1;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[256];
            int count = 0;
            for (char c : t.toCharArray()) {
                freq[c]++;
            }
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                if (freq[ch] > 0) {
                    count++;
                    freq[ch]--;
                }
                if (count == t.length()) {
                    if (j - i + 1 < minLen) {
                        minLen = j - i + 1;
                        startIndex = i;
                    }
                    break;
                }
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }

    public static void main(String[] args) {
//        String s = "ADOBECODEBANC", t = "ABC";
        String s = "aAbBDdcC", t = "Bc";
        System.out.println(method1(s, t));
        System.out.println(minWindow(s, t));
    }
}
