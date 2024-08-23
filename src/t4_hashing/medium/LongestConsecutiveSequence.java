package t4_hashing.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> se = new HashSet<>();
        for (int num : nums) {
            se.add(num);
        }
        int longest = 1;
        for (int ele : se) {
            if (!se.contains(ele - 1)) {
                int temp = ele;
                int count = 1;
                while (se.contains(temp + 1)) {
                    count++;
                    temp++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
