package t6_recursion.subsequence_pattern;

public class SubsequenceExistsOrNot {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        return check(0, 0, k, nums);
    }

    boolean check(int ind, int currSum, int k, int[] nums) {
        if (currSum > k)
            return false;
        if (currSum == k)
            return true;
        if (ind == nums.length)
            return false;
        //take case
        if (check(ind + 1, currSum + nums[ind], k, nums)) {
            return true;
        }
        //not take case
        return check(ind + 1, currSum, k, nums);
    }
}
