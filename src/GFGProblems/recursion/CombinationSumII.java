package GFGProblems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        Arrays.sort(arr);
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        generate(0, k, arr, curr, ans);
        return ans;
    }

    void generate(int ind, int k, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        if (k == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (k < 0 || ind == nums.length)
            return;
        //take case
        curr.add(nums[ind]);
        generate(ind + 1, k - nums[ind], nums, curr, ans);
        //not take case
        curr.remove(curr.size() - 1);
        int nextInd = upperBound(nums, nums[ind]);
        generate(nextInd, k, nums, curr, ans);
    }

    int upperBound(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
