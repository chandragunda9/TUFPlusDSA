package binary_search.logic_building;

public class FloorAndCeilInSortedArray {
    public int[] getFloorAndCeil1(int[] nums, int x) {
        int floor = -1, ceil = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= x) {
                floor = nums[i];
            }
            if (nums[n - i - 1] >= x) {
                ceil = nums[n - i - 1];
            }
        }
        return new int[]{floor, ceil};
    }

    public int[] getFloorAndCeil(int[] nums, int x) {
        int[] ans = new int[2];
        ans[0] = floorValue(nums, x);
        ans[1] = ceilValue(nums, x);
        return ans;
    }

    int floorValue(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high == -1 ? -1 : nums[high];
    }

    int ceilValue(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low == nums.length ? -1 : nums[low];
    }
}
