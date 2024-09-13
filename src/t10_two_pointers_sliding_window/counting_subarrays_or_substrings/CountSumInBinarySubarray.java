package t10_two_pointers_sliding_window.counting_subarrays_or_substrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSumInBinarySubarray {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return findCount(nums, goal) - findCount(nums, goal - 1);
    }

    static int findCount(int[] nums, int goal) {
        List<List<Integer>> all = new ArrayList<>();
        if (goal < 0)
            return 0;
        int l = 0, r = 0, sum = 0, count = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            all.add(new ArrayList<>(Arrays.asList(l, r)));
            count += r - l + 1;
            r++;
        }
        System.out.println(all);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int goal = 2;
//        int[] arr = {1, 1, 0, 1, 0, 0, 1};
//        int goal = 3;
        System.out.println(numSubarraysWithSum(arr, goal));
    }
}
