package hashing.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HighestOccurringElement {
    public int mostFrequentElement1(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int ele : nums) {
            freqMap.put(ele, freqMap.getOrDefault(ele, 0) + 1);
        }

        int mostFreqEle = -1, maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (freqMap.get(nums[i]) > maxFreq) {
                maxFreq = freqMap.get(nums[i]);
                mostFreqEle = nums[i];
            } else if (freqMap.get(nums[i]) == maxFreq) {
                mostFreqEle = Math.min(mostFreqEle, nums[i]);
            }
        }
        return mostFreqEle;
    }

    public int mostFrequentElement(int[] nums) {
        return Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .max((e1, e2) -> {
                    int freqCompare = e1.getValue().compareTo(e2.getValue());
                    if (freqCompare == 0) {
                        return e2.getKey().compareTo(e1.getKey());
                    }
                    return freqCompare;
                })
                .get()
                .getKey();
    }
}
