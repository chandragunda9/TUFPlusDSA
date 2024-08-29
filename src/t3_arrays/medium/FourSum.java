package t3_arrays.medium;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 4, -3};
        int target = 5;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int l = n - 1; l >= 0; l--) {
            if (l < n - 1 && nums[l] == nums[l + 1])
                continue;
            for (int k = l - 1; k >= 0; k--) {
                if (k < l - 1 && nums[k] == nums[k + 1])
                    continue;
                int i = 0, j = k - 1;
                while (i < j) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while (i < j && nums[i] == nums[i + 1])
                            i++;
                        while (i < j && nums[j] == nums[j - 1])
                            j--;
                        i++;
                        j--;
                    } else if (sum > target) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> fourSum1(int[] arr, int target) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        for (int l = n - 1; l >= 3; l--) {
            if (l < n - 1 && arr[l] == arr[l + 1])
                continue;
            for (int k = l - 1; k >= 2; k--) {
                if (k < l - 1 && arr[k] == arr[k + 1])
                    continue;
                int i = 0, j = k - 1;
                while (i < j) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        ans.add(temp);
                        while (i < j && arr[i] == arr[i + 1]) i++;
                        while (i < j && arr[j] == arr[j - 1]) j--;
                        i++;
                        j--;
                    } else if (sum > target) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }
        }
        ans.sort((o1, o2) -> {
            for (int i = 0; i < 4; i++) {
                int cmp = o1.get(i).compareTo(o2.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        });
        return ans;
    }
}
