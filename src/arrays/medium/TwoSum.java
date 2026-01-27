package arrays.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum1(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return ans;
    }

    public int[] twoSum(int[] nums, int target) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (arr[left][0] + arr[right][0] == target) {
                return new int[]{arr[left][1], arr[right][1]};
            } else if (arr[left][0] + arr[right][0] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
