package t10_two_pointers_sliding_window.longest_smallest_window_problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKDistinctCharacters {
    public static int method2(String s, int k) {
        int maxLen = 0;
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() > k) {
                char leftCh = s.charAt(l);
                map.put(leftCh, map.get(leftCh) - 1);
                if (map.get(leftCh) == 0) {
                    map.remove(leftCh);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public static int kDistinctChar(String s, int k) {
        int maxLen = 0;
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.size() > k) {
                char leftCh = s.charAt(l);
                map.put(leftCh, map.get(leftCh) - 1);
                if (map.get(leftCh) == 0) {
                    map.remove(leftCh);
                }
                l++;
            }
            if (map.size() <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String st = "abcddefg";
        int k = 3;
        System.out.println(kDistinctChar(st, k));
    }
}
