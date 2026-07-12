package hashing_practice.faq;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, -1);
        int sum = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefixSums.containsKey(sum - k)) {
                int len = i - prefixSums.get(sum - k);
                ans = Math.max(ans, len);
            }
            if (!prefixSums.containsKey(sum)) {
                prefixSums.put(sum, i);
            }
        }
        return ans;
    }
}
