package t6_recursion.subsequence_pattern;

public class CountAllSubsequences {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return count(0, 0, k, nums);
    }

    int count(int ind, int currSum, int k, int[] nums) {
        if (currSum == k)
            return 1;
        if (currSum > k)
            return 0;
        if (ind == nums.length)
            return 0;
        int takeCaseCount = count(ind + 1, currSum + nums[ind], k, nums);
        int notTakeCaseCount = count(ind + 1, currSum, k, nums);
        return takeCaseCount + notTakeCaseCount;
    }
}
