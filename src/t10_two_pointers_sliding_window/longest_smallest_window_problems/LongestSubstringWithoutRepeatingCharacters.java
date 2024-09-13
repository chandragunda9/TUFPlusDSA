package t10_two_pointers_sliding_window.longest_smallest_window_problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int longestNonRepeatingSubstring(String s) {
        int left = 0, right = 0, maxLen = 1;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            map.put(ch, right);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String st = "aaabbbccc";
        System.out.println(longestNonRepeatingSubstring(st));
    }
}
