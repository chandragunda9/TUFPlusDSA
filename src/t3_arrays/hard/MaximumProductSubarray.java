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
}
