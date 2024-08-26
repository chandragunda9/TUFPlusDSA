package t5_binary_search.faqs;

public class SplitArrayLargestSum {
    int noOfSubarrays(int[] nums, int mid) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= mid) {
                sum += nums[i];
            } else {
                sum = nums[i];
                count++;
            }
        }
        count++;
        return count;
    }

    public int largestSubarraySumMinimized(int[] a, int k) {
        int sum = 0, n = a.length, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            max = Math.max(max, a[i]);
        }
        int low = max, high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = noOfSubarrays(a, mid);
            if (count > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
