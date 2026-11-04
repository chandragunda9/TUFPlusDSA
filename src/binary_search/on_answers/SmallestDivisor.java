package binary_search.on_answers;

public class SmallestDivisor {
    int f(int[] nums, int mid) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < mid)
                sum++;
            else
                sum += Math.ceil((double) nums[i] / mid);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int limit) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        int low = 1, high = maxi;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = f(nums, mid);
            if (res <= limit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
