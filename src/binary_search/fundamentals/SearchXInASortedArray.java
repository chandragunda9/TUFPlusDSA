package binary_search.fundamentals;

public class SearchXInASortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //Recursive solution
    public int search1(int[] nums, int target) {
        return find(nums, 0, nums.length - 1, target);
    }

    public int find(int[] nums, int low, int high, int target) {
        if (high < low)
            return -1;
        int mid = (low + high) / 2;
        if (nums[mid] == target)
            return mid;
        if (target < nums[mid]) {
            return find(nums, low, mid - 1, target);
        }
        return find(nums, mid + 1, high, target);
    }
}
