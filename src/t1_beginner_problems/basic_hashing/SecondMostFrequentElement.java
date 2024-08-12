package t1_beginner_problems.basic_hashing;

import java.util.HashMap;
import java.util.Map;

public class SecondMostFrequentElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};
        System.out.println(secondMostFrequentElement(arr));
    }

    public static int secondMostFrequentElement(int[] nums) {
        Map<Integer, Integer> elementCounts = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            elementCounts.put(nums[i], elementCounts.getOrDefault(nums[i], 0) + 1);
            maxFreq = Math.max(maxFreq, elementCounts.get(nums[i]));
        }
        int secondMaxEle = 0, secondMaxFreq = 0;
        for (Map.Entry<Integer, Integer> entry : elementCounts.entrySet()) {
            int ele = entry.getKey(), count = entry.getValue();
            if (count > secondMaxFreq && count < maxFreq) {
                secondMaxEle = ele;
                secondMaxFreq = count;
            } else if (count == secondMaxFreq) {
                secondMaxEle = Math.min(secondMaxEle, ele);
            }
        }
        return secondMaxEle != 0 ? secondMaxEle : -1;
    }
}
