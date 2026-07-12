package hashing_practice.faq;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenSum {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, n = nums.length;
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        prefixSumCounts.put(0, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (prefixSumCounts.containsKey(sum - k)) {
                ans += prefixSumCounts.get(sum - k);
            }
            prefixSumCounts.put(sum, prefixSumCounts.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
