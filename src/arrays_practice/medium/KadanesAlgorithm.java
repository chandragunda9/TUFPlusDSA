package arrays_practice.medium;

public class KadanesAlgorithm {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE, start = 0;
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
                ans[0] = start;
                ans[1] = i;
            }
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        for (int i = ans[0]; i <= ans[1]; i++) {
            System.out.print(nums[i] + " ");
        }
        return maxSum;
    }
}
