package t6_recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findAllSubsets(0, nums, curr, ans);
        return ans;
    }

    void findAllSubsets(int ind, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        if (ind == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        //take case
        curr.add(nums[ind]);
        findAllSubsets(ind + 1, nums, curr, ans);
        //not take case
        curr.remove(curr.size() - 1);
        int nextInd = upperBound(nums, ind + 1, nums[ind]);
        findAllSubsets(nextInd, nums, curr, ans);
    }

    int upperBound(int[] nums, int low, int x) {
        int high = nums.length - 1;
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

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        SubsetsII obj = new SubsetsII();
        System.out.println(obj.subsetsWithDup(nums));
    }
}
