package t5_binary_search.logic_building;

import java.util.Arrays;

public class FloorAndCeil {
    public int[] getFloorAndCeil(int[] nums, int x) {
//        int floor = -1, ceil = -1, n = nums.length;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] <= x)
//                floor = nums[i];
//            if (nums[n - 1 - i] >= x)
//                ceil = nums[n - 1 - i];
//        }
//        return new int[]{floor, ceil};
        int[] ans = new int[2];
        ans[0] = getFloor(nums, x);
        ans[1] = getCeil(nums, x);
        return ans;
    }

    public int getFloor(int[] nums, int x) {
        int n = nums.length, l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r == -1 ? -1 : nums[r];
    }

    public int getCeil(int[] nums, int x) {
        int n = nums.length, l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l == n ? -1 : nums[l];
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int x = 6;
        FloorAndCeil obj = new FloorAndCeil();
        System.out.println(Arrays.toString(obj.getFloorAndCeil(arr, x)));
    }
}
