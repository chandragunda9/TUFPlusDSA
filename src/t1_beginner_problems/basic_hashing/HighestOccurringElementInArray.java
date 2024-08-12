package t1_beginner_problems.basic_hashing;

import java.util.HashMap;
import java.util.Map;

public class HighestOccurringElementInArray {
    public int mostFrequentElement(int[] nums) {
        int maxEle = 0, maxFreq = 0;
        Map<Integer, Integer> elementCounts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            elementCounts.put(nums[i], elementCounts.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : elementCounts.entrySet()) {
            int count = entry.getValue();
            if (count > maxFreq) {
                maxEle = entry.getKey();
                maxFreq = count;
            } else if (count == maxFreq) {
                maxEle = Math.min(maxEle, entry.getKey());
            }
        }
        return maxEle;
    }
}
