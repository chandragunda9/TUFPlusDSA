package t10_two_pointers_sliding_window.longest_smallest_window_problems;

public class MaximumConsecutiveOnesIII {
    public static int method2(int[] nums, int k) {
        //longest subarray with atmost k zeroes
        int left = 0, right = 0, zeroes = 0;
        int maxLen = 0;
        while (right < nums.length) {
            if (nums[right] == 0)
                zeroes++;
            while (zeroes > k) {
                if (nums[left] == 0) {
                    zeroes--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public static int longestOnes(int[] nums, int k) {
        //longest subarray with atmost k zeroes
        int left = 0, right = 0, zeroes = 0;
        int maxLen = 0;
        while (right < nums.length) {
            if (nums[right] == 0)
                zeroes++;
            if (zeroes > k) {
                if (nums[left] == 0) {
                    zeroes--;
                }
                left++;
            }
            if (zeroes <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 3;
        System.out.println(longestOnes(arr, k));
    }
}
