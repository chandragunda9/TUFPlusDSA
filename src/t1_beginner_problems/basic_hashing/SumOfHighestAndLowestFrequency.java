package t1_beginner_problems.basic_hashing;

import java.util.HashMap;
import java.util.Map;

public class SumOfHighestAndLowestFrequency {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};
        System.out.println(sumHighestAndLowestFrequency(arr));
    }

    public static int sumHighestAndLowestFrequency(int[] nums) {
        Map<Integer, Integer> elementFreqMap = new HashMap<>();
        int maxFreq = 0, minFreq = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            elementFreqMap.put(nums[i], elementFreqMap.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : elementFreqMap.entrySet()) {
            maxFreq = Math.max(maxFreq, entry.getValue());
            minFreq = Math.min(minFreq, entry.getValue());
        }
        return maxFreq + minFreq;
    }
}
