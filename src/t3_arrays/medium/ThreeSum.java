package t3_arrays.medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int k = n - 1; k >= 2; k--) {
            if (k == n - 1 || nums[k] != nums[k + 1]) {
                int l = 0, r = k - 1;
                while (l < r) {
                    if (nums[l] + nums[r] + nums[k] == 0) {
                        ans.add(Arrays.asList(nums[l], nums[r], nums[k]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] + nums[k] > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> method2(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> resSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> se = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (se.contains(third)) {
                    List<Integer> li = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(li);
                    resSet.add(new ArrayList<>(li));
                }
                se.add(nums[j]);
            }
        }
        return new ArrayList<>(resSet);
    }

    public static void main(String[] args) {
        int[] arr = {8, -6, 5, 4};
        ThreeSum obj = new ThreeSum();
        List<List<Integer>> ans = obj.method2(arr);
        System.out.println(ans);
    }

    public static boolean find3Numbers(int arr[], int n, int x) {
        Arrays.sort(arr);
        for (int k = n - 1; k >= 2; k--) {
            int l = 0, r = k - 1;
            while (l < r) {
                if (arr[l] + arr[r] + arr[k] == x)
                    return true;
                else if (arr[l] + arr[r] + arr[k] > x) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return false;
    }
}
