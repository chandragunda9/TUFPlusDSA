package t6_recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class SubsetsI {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        findAllSubsets(0, nums, 0, ans);
        return ans;
    }

    void findAllSubsets(int ind, int[] nums, int currSum, List<Integer> ans) {
        if (ind == nums.length) {
            ans.add(currSum);
            return;
        }
        //take case
        findAllSubsets(ind + 1, nums, currSum + nums[ind], ans);
        //not take case
        findAllSubsets(ind + 1, nums, currSum, ans);
    }

    public List<Integer> method1(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        generateAllSums(0, 0, nums, ans);
        return ans;
    }

    void generateAllSums(int ind, int currSum,
                         int[] nums, ArrayList<Integer> ans) {
        ans.add(currSum);
        for (int i = ind; i < nums.length; i++) {
            generateAllSums(i + 1, currSum + nums[i], nums, ans);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 1};
        SubsetsI obj = new SubsetsI();
        System.out.println(obj.method1(nums));
        System.out.println(obj.subsetSums(nums));
    }
}
