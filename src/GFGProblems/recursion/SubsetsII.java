package GFGProblems.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> curr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        generate(0, nums, curr, ans);
        return ans;
    }

    static void generate(int ind, int[] nums, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans) {
        ans.add(new ArrayList<>(curr));
        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1])
                continue;
            //take case
            curr.add(nums[i]);
            generate(i + 1, nums, curr, ans);
            //removing last added element
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(SubsetsII.printUniqueSubsets(nums));
    }
}
