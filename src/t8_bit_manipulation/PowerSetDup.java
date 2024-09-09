package t8_bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSetDup {
    public List<List<Integer>> powerSet(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int noOfSubsets = 1 << n;
        for (int i = 0; i < noOfSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0)
                    subset.add(nums[j]);
            }
            ans.add(subset);
        }
        return ans;
        //Time: O(n*2^n)
        //Space: O(n*2^n)
    }
}
