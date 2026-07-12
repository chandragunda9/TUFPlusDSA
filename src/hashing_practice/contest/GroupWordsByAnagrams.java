package hashing_practice.contest;

import java.util.*;

public class GroupWordsByAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(word);
        }
        return new ArrayList<>(groups.values());
    }
}
