package hashing.basic;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondHighestOccurringElement {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(secondMostFrequentElement(arr));
    }

    public static int secondMostFrequentElement1(int[] nums) {
        int maxFreq = 0;

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int ele : nums) {
            freqMap.put(ele, freqMap.getOrDefault(ele, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(ele));
        }

        int secondMaxFreq = 0, secondMaxEle = -1;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int count = entry.getValue();
            if (count > secondMaxFreq && count < maxFreq) {
                secondMaxFreq = count;
                secondMaxEle = entry.getKey();
            } else if (count == secondMaxFreq) {
                secondMaxEle = Math.min(secondMaxEle, entry.getKey());
            }
        }
        return secondMaxEle;
    }

    public static int secondMostFrequentElement(int[] nums) {
        Map<Integer, Long> freqMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        if (freqMap.size() < 2)
            return -1;

        List<Long> sortedFreq = freqMap.values().stream()
                .distinct().sorted(Comparator.reverseOrder())
                .toList();

        if (sortedFreq.size() < 2)
            return -1;

        long secondMaxFreq = sortedFreq.get(1);
        return freqMap.entrySet().stream()
                .filter(e -> e.getValue() == secondMaxFreq)
                .map(Map.Entry::getKey)
                .min(Integer::compareTo)
                .orElse(-1);
    }
}
