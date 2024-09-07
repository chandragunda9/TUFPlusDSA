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

    public void func(int[] v, int i, int sum, List<Integer> v2, List<List<Integer>> ans) {
        // If the sum is 0, we found a valid combination
        if (sum == 0) {
            // Add the current combination to the answer list
            ans.add(new ArrayList<>(v2));
            return;
        }
        // If sum becomes negative or index goes out of bounds, return
        if (sum < 0 || i >= v.length) {
            return;
        }

        // Loop through the array starting from index i
        for (int j = i; j < v.length; j++) {
            // Skip duplicates to avoid redundant combinations
            if (j > i && v[j] == v[j - 1]) {
                continue;
            }
            // Add current number to the combination
            v2.add(v[j]);
            // Recur with the next index and updated sum
            func(v, j + 1, sum - v[j], v2, ans);
            // Remove the last number added to backtrack
            v2.remove(v2.size() - 1);
        }
    }

    // Main function to get all unique combinations
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        // Sort the array to handle duplicates easily
        Arrays.sort(candidates);
        // Call the helper function to start finding combinations
        func(candidates, 0, target, v, ans);
        return ans;
    }

    // Main method to run the code
    public static void main(String[] args) {
        CombinationSumII sol = new CombinationSumII();
        // Example input
//        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
//        int target = 8;
        int[] candidates = {1, 2, 2};
        int target = 1;
        // Get the combinations
        List<List<Integer>> result = sol.combinationSum2(candidates, target);
        // Print the result
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
