package t5_binary_search.logic_building;

public class FirstAndLastOccurrence {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurrence = lowerBound(nums, target);
        if (firstOccurrence == nums.length || nums[firstOccurrence] != target) {
            return new int[]{-1, -1};
        }
        int lastOccurrence = upperBound(nums, target);
        return new int[]{firstOccurrence, lastOccurrence - 1};
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
            int mid = (low + high) / 2;
            if (nums[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int[] method2(int[] nums, int target) {
        //first occurrence
        int first = -1, last = -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (first == -1) {
            return new int[]{-1, -1};
        }

        //last occurrence
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[]{first, last};
    }
}
