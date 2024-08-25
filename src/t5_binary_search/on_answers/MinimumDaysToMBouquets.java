package t5_binary_search.on_answers;

public class MinimumDaysToMBouquets {
    int f(int[] nums, int mid, int noOfFlowers) {
        int count = 0, noOfBouquets = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid)
                count++;
            else {
                noOfBouquets += count / noOfFlowers;
                count = 0;
            }
        }
        noOfBouquets += count / noOfFlowers;
        return noOfBouquets;
    }

    public int roseGarden(int n, int[] nums, int k, int m) {
        if (n < m * k)
            return -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int low = min, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            int noOfBouquets = f(nums, mid, k);
            if (noOfBouquets >= m)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}
