package binary_search.on_answers;

public class KokoEatingBananas {
    public int minimumRateToEatBananas(int[] nums, int h) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        int low = 1, high = maxi;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = f(nums, mid, h);
            if (cmp > 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    int f(int[] nums, int mid, int h) {
        int numHours = 0;
        for (int i = 0; i < nums.length; i++) {
            numHours += Math.ceil((double) nums[i] / mid);
            if (numHours > h)
                return 1;
        }
        return numHours == h ? 0 : -1;
    }
}
