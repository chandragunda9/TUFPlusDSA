package arrays_practice.hard;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int prefix = 1, suffix = 1;
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            maxProd = Math.max(maxProd, Math.max(prefix, suffix));
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
        }
        return maxProd;
    }
}
