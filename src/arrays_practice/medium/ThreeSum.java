package arrays_practice.medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> tripletSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int rem = -(nums[i] + nums[j]);
                if (set.contains(rem)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], rem);
                    Collections.sort(temp);
                    tripletSet.add(temp);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(tripletSet);
    }

    public List<List<Integer>> threeSum1(int[] nums, int low, int high) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int k = n - 1; k >= 2; k--) {
            if (k < n - 1 && nums[k] == nums[k + 1])
                continue;
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return ans;
    }
}
