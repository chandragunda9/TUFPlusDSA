package t1_beginner_problems.basic_strings;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nataram";
        System.out.println(method1(s, t));
    }

    public static boolean method1(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    public boolean anagramStrings(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] charFreqCount = new int[26];
        for (char ch : s.toCharArray()) {
            charFreqCount[ch - 'a'] += 1;
        }
        for (char ch : t.toCharArray()) {
            charFreqCount[ch - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if (charFreqCount[i] != 0)
                return false;
        }
        return true;
    }
}
