package t4_hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumKPos {
    public static void main(String[] args) {
        int[] nums = {2};
        int k = 0;
        System.out.println(longestSubarray(nums, k));
    }

    public static int longestSubarray(int[] nums, int k) {
        int n = nums.length, sum = 0, longest = 0;
        int l = 0, r = 0;
        while (r < n) {
            sum += nums[r];
            while (l < r && sum > k) {
                sum -= nums[l];
                l++;
            }
            if (sum == k) {
                longest = Math.max(longest, r - l + 1);
            }
            r++;
        }
        return longest;
    }
}
