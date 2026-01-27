package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int l = n - 1; l >= 3; l--) {
            if (l < n - 1 && nums[l] == nums[l + 1])
                continue;
            for (int k = l - 1; k >= 2; k--) {
                if (k < l - 1 && nums[k] == nums[k + 1])
                    continue;
                int i = 0, j = k - 1;
                while (i < j) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
                        while (i < j && nums[i] == nums[i + 1]) {
                            i++;
                        }
                        while (i < j && nums[j] == nums[j - 1]) {
                            j--;
                        }
                        i++;
                        j--;
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }
        return ans;
    }
}
