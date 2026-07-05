package hashing.faq;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenSum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumCounts = new HashMap<>();
        sumCounts.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumCounts.containsKey(sum - k)) {
                count += sumCounts.get(sum - k);
            }
            sumCounts.put(sum, sumCounts.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
