package binary_search.faq;

import java.util.Arrays;

public class SplitArrayLargestSum {
    public static int largestSubarraySumMinimized(int[] a, int k) {
        int n = a.length;
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
            sum += a[i];
        }
        int low = max, high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            int res = countSplits(a, mid);
            if (res > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    static int countSplits(int[] a, int mid) {
        int sum = a[0], count = 1;
        for (int i = 1; i < a.length; i++) {
            if (sum + a[i] <= mid) {
                sum += a[i];
            } else {
                sum = a[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 1};
        int k = 3;
        System.out.println(largestSubarraySumMinimized(nums, k));
    }
}
