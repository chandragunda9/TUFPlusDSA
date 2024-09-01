package t6_recursion.medium;

import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> method1(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        findCombinations(0, target, candidates, curr, ans);
        return new ArrayList<>(ans);
    }

    void findCombinations(int ind, int target, int[] nums, List<Integer> curr, Set<List<Integer>> ans) {
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
        findCombinations(ind + 1, target - nums[ind], nums, curr, ans);
        //not take case
        curr.remove(curr.size() - 1);
        findCombinations(ind + 1, target, nums, curr, ans);
    }

    public static void main(String[] args) {
        CombinationSumII obj = new CombinationSumII();
        int target = 5;
        int[] nums = {2, 1, 2};
        System.out.println(obj.method1(nums, target));
        System.out.println(obj.combinationSum2(nums, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, target, candidates, curr, ans);
        return ans;
    }

    void findCombinations(int ind, int target, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0)
            return;
        if (ind == nums.length)
            return;
        //take case
        curr.add(nums[ind]);
        findCombinations(ind + 1, target - nums[ind], nums, curr, ans);
        //not take case
        curr.remove(curr.size() - 1);
        int nextInd = upperBound(nums, nums[ind]);
        findCombinations(nextInd, target, nums, curr, ans);
    }

    int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
