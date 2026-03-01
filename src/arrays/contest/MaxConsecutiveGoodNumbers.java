package arrays.contest;

import java.util.HashSet;
import java.util.Set;

public class MaxConsecutiveGoodNumbers {
    public int maxConsecutiveGoodNums(int[] nums, int[] goodNumbers) {
        Set<Integer> se = new HashSet<>();
        int n = nums.length, gn = goodNumbers.length;
        for (int i = 0; i < gn; i++) {
            se.add(goodNumbers[i]);
        }

        int ans = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (se.contains(nums[i])) {
                count++;
                ans = Math.max(count, ans);
            } else {
                count = 0;
            }
        }
        return ans;
    }
}
