package t10_two_pointers_sliding_window.counting_subarrays_or_substrings;

import java.util.Arrays;

public class CountSubstringsContainingAllCharacters {
    public static int numberOfSubstrings(String s) {
        int[] lastSeenIndex = new int[3];
        Arrays.fill(lastSeenIndex, -1);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastSeenIndex[ch - 'a'] = i;
            if (lastSeenIndex[0] != -1 && lastSeenIndex[1] != -1 && lastSeenIndex[2] != -1) {
                count += 1 + Math.min(lastSeenIndex[0], Math.min(lastSeenIndex[1], lastSeenIndex[2]));
            }
        }
        return count;
    }

    public static int method1(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[3];
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                hash[ch - 'a'] = 1;
                if (hash[0] + hash[1] + hash[2] == 3) {
//                    count++;
//                    instead of adding 1 to count since current substring is valid we can do below code for slight optimization
                    count += s.length() - j;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String st = "abccba";
//        String st = "abcba";
        System.out.println(numberOfSubstrings(st));
        System.out.println(method1(st));
    }
}
