package hashing.faq;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> se = new HashSet<>();
        for (int ele : nums) {
            se.add(ele);
        }

        int maxCount = 0;
        int count;
        for (int i = 0; i < nums.length; i++) {
            if (!se.contains(nums[i] - 1)) {
                count = 0;
                int next = nums[i];
                while (se.contains(next)) {
                    count += 1;
                    next++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
