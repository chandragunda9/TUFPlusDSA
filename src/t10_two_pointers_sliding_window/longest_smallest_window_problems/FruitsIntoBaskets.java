package t10_two_pointers_sliding_window.longest_smallest_window_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitsIntoBaskets {
    public int method1(int[] fruits) {
        int n = fruits.length, maxLen = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> se = new HashSet<>();
            for (int j = i; j < n; j++) {
                se.add(fruits[i]);
                if (se.size() <= 2) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    public int method2(int[] fruits) {
        int n = fruits.length;
        int l = 0, r = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public int totalFruits(int[] fruits) {
        int n = fruits.length;
        int l = 0, r = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            if (map.size() <= 2) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2};
        FruitsIntoBaskets obj = new FruitsIntoBaskets();
        System.out.println(obj.method2(arr));
        System.out.println(obj.totalFruits(arr));
    }
}
