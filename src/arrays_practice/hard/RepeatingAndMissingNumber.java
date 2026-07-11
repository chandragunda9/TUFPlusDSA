package arrays_practice.hard;

import java.util.ArrayList;
import java.util.List;

public class RepeatingAndMissingNumber {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
            xor ^= (i + 1);
        }
        int pos = 0;
        while (true) {
            if ((xor & (1 << pos)) != 0) {
                break;
            }
            pos++;
        }
        int ones = 0, zeroes = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & (1 << pos)) != 0) {
                ones ^= nums[i];
            } else {
                zeroes ^= nums[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & (1 << pos)) != 0) {
                ones ^= i;
            } else {
                zeroes ^= i;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == ones) {
                count++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (count != 0) {
            ans.add(ones);
            ans.add(zeroes);
        } else {
            ans.add(zeroes);
            ans.add(ones);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] findMissingRepeatingNumbers1(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
            xor ^= (i + 1);
        }
        int val = xor & -xor;
        int ones = 0, zeroes = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & val) != 0) {
                ones ^= nums[i];
            } else {
                zeroes ^= nums[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & val) != 0) {
                ones ^= i;
            } else {
                zeroes ^= i;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == ones) {
                count++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (count != 0) {
            ans.add(ones);
            ans.add(zeroes);
        } else {
            ans.add(zeroes);
            ans.add(ones);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
