package t5_binary_search.on_answers;

public class KokoEatingBananas {
    int f(int[] nums, int mid) {
        int hours = 0;
        for (int i = 0; i < nums.length; i++) {
            hours += Math.ceil((double) nums[i] / mid);
        }
        return hours;
    }

    public int minimumRateToEatBananas(int[] nums, int h) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxi = Math.max(maxi, nums[i]);
        }
        int low = 1, high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            int res = f(nums, mid);
            if (res <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
