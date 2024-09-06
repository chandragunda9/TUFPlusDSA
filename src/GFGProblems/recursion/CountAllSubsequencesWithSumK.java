package GFGProblems.recursion;

public class CountAllSubsequencesWithSumK {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return count(0, k, nums);
    }

    int count(int ind, int k, int[] nums) {
        if (k == 0) {
            return 1;
        }
        if (k < 0 || ind == nums.length) {
            return 0;
        }
        //take case count
        int takeCase = count(ind + 1, k - nums[ind], nums);
        //not take case count
        int notTakeCase = count(ind + 1, k, nums);
        return takeCase + notTakeCase;
    }
}
