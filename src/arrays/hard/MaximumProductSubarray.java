package arrays.hard;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 4, -4, -3};
        MaximumProductSubarray obj = new MaximumProductSubarray();
        System.out.println(obj.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int prefix = 1, suffix = 1, ans = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            ans = Math.max(ans, Math.max(prefix, suffix));
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
        }
        return ans;
    }
}
