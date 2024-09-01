package t5_binary_search.fundamentals;

public class UpperBound {
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

    public static void main(String[] args) {
        int[] nums = {3, 6, 7, 8, 19, 23};
        int x = 23;
        UpperBound obj = new UpperBound();
        System.out.println(obj.upperBound(nums, x));
    }
}
