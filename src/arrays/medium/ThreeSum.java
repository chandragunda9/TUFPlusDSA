package arrays.medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> tripletSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (set.contains(third)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);
                    Collections.sort(temp);
                    tripletSet.add(temp);
                }
                set.add(nums[j]);
            }
        }

        return new ArrayList<>(tripletSet);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int k = n - 1; k >= 2; k--) {
            if (k != n - 1 || nums[k] == nums[k + 1])
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
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return ans;
    }
}
