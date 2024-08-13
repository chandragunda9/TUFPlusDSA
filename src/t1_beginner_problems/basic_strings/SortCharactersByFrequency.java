package t1_beginner_problems.basic_strings;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "raaaajjjjj";
        System.out.println(frequencySort(s));
    }

    public static List<Character> frequencySort(String s) {
        Map<Character, Integer> initialMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            initialMap.put(ch, initialMap.getOrDefault(ch, 0) + 1);
        }

        Comparator<Character> comp = (o1, o2) -> {
            int count1 = initialMap.get(o1);
            int count2 = initialMap.get(o2);
            if (count1 == count2) {
                return Character.compare(o1, o2);
            }
            return Integer.compare(count2, count1);
        };

        TreeMap<Character, Integer> charFreqCounts = new TreeMap<>(comp);
        charFreqCounts.putAll(initialMap);
        return new ArrayList<>(charFreqCounts.keySet());
    }
}
