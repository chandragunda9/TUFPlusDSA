package GFGProblems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubsetsI {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        generate(0, 0, arr, ans);
        return ans;
    }

    void generate(int ind, int currSum,
                  ArrayList<Integer> nums, ArrayList<Integer> ans) {
        if (ind == nums.size()) {
            ans.add(currSum);
            return;
        }
        //take case
        generate(ind + 1, currSum + nums.get(ind), nums, ans);
        //not take case
        generate(ind + 1, currSum, nums, ans);
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
        int[] arr = {2, 3};
        ArrayList<Integer> al = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        SubsetsI obj = new SubsetsI();
        System.out.println(obj.method1(arr));
        System.out.println(obj.subsetSums(al, al.size()));
    }
}
