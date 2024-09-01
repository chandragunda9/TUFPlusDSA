package t6_recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        findCombinations(0, target, candidates, curr, ans);
        return ans;
    }

    void findCombinations(int ind, int target, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        if (target < 0)
            return;
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (ind == nums.length)
            return;
        //take case
        curr.add(nums[ind]);
        findCombinations(ind, target - nums[ind], nums, curr, ans);
        //not take case
        curr.remove(curr.size() - 1);
        findCombinations(ind + 1, target, nums, curr, ans);
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 5, 4};
        CombinationSumI obj = new CombinationSumI();
        System.out.println(obj.combinationSum(nums, target));
    }
}
