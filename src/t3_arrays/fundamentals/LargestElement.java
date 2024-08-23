package t3_arrays.fundamentals;

public class LargestElement {
    public int largestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
