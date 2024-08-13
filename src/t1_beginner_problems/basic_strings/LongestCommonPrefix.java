package t1_beginner_problems.basic_strings;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] str) {
        Arrays.sort(str);
        String firstWord = str[0], lastWord = str[str.length - 1];
        int i = 0;
        for (i = 0; i < Math.min(firstWord.length(), lastWord.length()); i++) {
            if (firstWord.charAt(i) != lastWord.charAt(i)) {
                break;
            }
        }
        if (i == 0)
            return "";
        return firstWord.substring(0, i);
    }
}
