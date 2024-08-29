package t3_arrays.hard;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int prefix = 1, suffix = 1, max = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            prefix *= nums[i];
            suffix *= nums[n - 1 - i];
            max = Math.max(max, Math.max(prefix, suffix));
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
        }
        return max;
    }

    public int method1(int[] nums) {
        int prod1 = nums[0], prod2 = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(nums[i], Math.max(prod1 * nums[i], prod2 * nums[i]));
            prod2 = Math.min(nums[i], Math.max(prod1 * nums[i], prod2 * nums[i]));
            prod1 = temp;
            res = Math.max(res, prod1);
        }
        return res;
    }

    long maxProduct(int[] nums, int n) {
        long prod1 = nums[0], prod2 = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            long temp = Math.max(nums[i], Math.max(prod1 * nums[i], prod2 * nums[i]));
            prod2 = Math.min(nums[i], Math.max(prod1 * nums[i], prod2 * nums[i]));
            prod1 = temp;
            res = Math.max(res, prod1);
        }
        return res;
    }
}
