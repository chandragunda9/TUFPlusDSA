package t4_hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumKPosAndNeg {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int longest = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (prefixSums.containsKey(sum - k)) {
                int ind = prefixSums.get(sum - k);
                longest = Math.max(longest, i - ind);
            }
            if (!prefixSums.containsKey(sum))
                prefixSums.put(sum, i);
        }
        return longest;
    }
}
