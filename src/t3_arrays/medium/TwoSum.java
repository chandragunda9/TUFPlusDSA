package t3_arrays.medium;

import java.util.*;

public class TwoSum {
    public int[] method1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            }
        }
        return ans;
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int[][] eleIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            eleIndex[i][0] = nums[i];
            eleIndex[i][1] = i;
        }
        Arrays.sort(eleIndex, Comparator.comparingInt(o -> o[0]));

        int l = 0, r = n - 1;
        while (l < r) {
            int leftEle = eleIndex[l][0];
            int rightEle = eleIndex[r][0];
            if (leftEle + rightEle == target) {
                ans.add(eleIndex[l][1]);
                ans.add(eleIndex[r][1]);
                break;
            }
            else if (leftEle + rightEle > target) {
                r--;
            }
            else {
                l++;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
