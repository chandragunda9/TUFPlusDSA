package binary_search.logic_building;

public class SearchInARotatedSortedArrayI {
    public int search(int[] nums, int k) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == k)
                return mid;
            if (nums[mid] <= nums[high]) {
                if (nums[mid] < k && k <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (nums[low] <= k && k <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
