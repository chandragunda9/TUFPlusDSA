package hashing_practice.faq;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceInArray {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int next = nums[i];
                int count = 0;
                while (set.contains(next)) {
                    count += 1;
                    next += 1;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
