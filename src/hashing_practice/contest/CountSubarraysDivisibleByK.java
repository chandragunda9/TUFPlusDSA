package hashing_practice.contest;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysDivisibleByK {
    public int subarraySumDivisbleByK(int[] nums, int k) {
        Map<Integer, Integer> remainderCounts = new HashMap<>();
        remainderCounts.put(0, 1);
        int prefixSum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remainder = (prefixSum % k + k) % k;
            count +=remainderCounts.getOrDefault(remainder, 0);
            remainderCounts.put(remainder, remainderCounts.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }
}
