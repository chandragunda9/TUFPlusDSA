package t6_recursion.implementation_problems;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getAllSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    void getAllSubsets(int ind, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        if (ind == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        //take case
        current.add(nums[ind]);
        getAllSubsets(ind + 1, nums, current, ans);
        //not take case
        current.remove(current.size() - 1);
        getAllSubsets(ind + 1, nums, current, ans);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        PowerSet obj = new PowerSet();
        System.out.println(obj.powerSet(nums));
    }
}
