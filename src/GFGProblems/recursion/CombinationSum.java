package GFGProblems.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum {
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        generate(0, B, A, curr, ans);
        return ans;
    }

    static void generate(int ind, int target, ArrayList<Integer> nums, ArrayList<Integer> curr,
                         ArrayList<ArrayList<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0 || ind == nums.size())
            return;
        //take case
        curr.add(nums.get(ind));
        generate(ind, target - nums.get(ind), nums, curr, ans);
        //not take case
        int newInd = ind;
        while (newInd < nums.size() && nums.get(newInd).equals(nums.get(ind))) {
            newInd++;
        }
        curr.remove(curr.size() - 1);
        generate(newInd, target, nums, curr, ans);
    }
}
