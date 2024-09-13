package t10_two_pointers_sliding_window.longest_smallest_window_problems;

public class LongestRepeatingCharacterReplacement {
    public static int method1(String s, int k) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                freq[ch - 'A']++;
                maxFreq = Math.max(maxFreq, freq[ch - 'A']);
                int noOfCharsToBeReplaced = (j - i + 1) - maxFreq;
                if (noOfCharsToBeReplaced <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        String st = "BAABAABBBAAA";
//        int k = 2;
        String st = "AABABBA";
        int k = 1;
        System.out.println(method1(st, k));
        System.out.println(characterReplacement(st, k));
    }

    public static int method2(String s, int k) {
        int[] freq = new int[26];
        int l = 0, r = 0, maxFreq = 0, maxLen = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            // noOfCharsToBeReplaced is  (r - l + 1) - maxFreq;
            while ((r - l + 1) - maxFreq > k) {
                char leftCh = s.charAt(l);
                freq[leftCh - 'A']--;
                for (int val : freq) {
                    maxFreq = Math.max(maxFreq, val);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0, r = 0, maxFreq = 0, maxLen = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            // noOfCharsToBeReplaced  =  (r - l + 1) - maxFreq;
            if ((r - l + 1) - maxFreq > k) {
                char leftCh = s.charAt(l);
                freq[leftCh - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
