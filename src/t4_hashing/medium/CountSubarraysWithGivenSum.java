package t4_hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenSum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        int n = nums.length, sum = 0, count = 0;
        prefixSumCounts.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int rem = sum - k;
            if (prefixSumCounts.containsKey(rem)) {
                count += prefixSumCounts.get(rem);
            }
            prefixSumCounts.put(sum, prefixSumCounts.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
