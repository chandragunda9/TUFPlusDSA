package t10_two_pointers_sliding_window.counting_subarrays_or_substrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountNiceSubarrays {
    public int numberOfOddSubarrays(int[] nums, int k) {
        return findCount(nums, k) - findCount(nums, k - 1);
    }

    static int findCount(int[] nums, int goal) {
        List<List<Integer>> all = new ArrayList<>();
        if (goal < 0)
            return 0;
        int l = 0, r = 0, sum = 0, count = 0;
        while (r < nums.length) {
            sum += (nums[r] % 2);
            while (sum > goal) {
                sum -= (nums[l] % 2);
                l++;
            }
            all.add(new ArrayList<>(Arrays.asList(l, r)));
            count += r - l + 1;
            r++;
        }
        System.out.println(all);
        return count;
    }
}
