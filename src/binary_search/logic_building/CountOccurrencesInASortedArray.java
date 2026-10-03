package binary_search.logic_building;

public class CountOccurrencesInASortedArray {
    public int countOccurrences(int[] arr, int target) {
        int lb = lowerBound(arr, target);
        int ub = upperBound(arr, target);
        return ub - lb;
    }

    public int lowerBound(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int upperBound(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
