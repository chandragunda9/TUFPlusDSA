package hashing.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumHighestAndLowestFrequency {
    public int sumHighestAndLowestFrequency1(int[] nums) {
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

    public int sumHighestAndLowestFrequency(int[] nums) {
        Map<Integer, Long> freqMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        if (freqMap.isEmpty()) {
            return 0;
        }

        long maxFreq = freqMap.values()
                .stream()
                .max(Long::compareTo)
                .orElse(0L);

        long minFreq = freqMap.values()
                .stream()
                .min(Long::compareTo)
                .orElse(0L);

        return (int) (maxFreq + minFreq);
    }
}
