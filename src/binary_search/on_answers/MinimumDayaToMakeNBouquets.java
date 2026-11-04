package binary_search.on_answers;

public class MinimumDayaToMakeNBouquets {
    public static int roseGarden(int n, int[] nums, int k, int m) {
        if (n < (long) k * m)
            return -1;
        int maxi = Integer.MIN_VALUE, mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
            mini = Math.min(mini, nums[i]);
        }
        int low = mini, high = maxi;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean isPossible = f(nums, mid, k, m);
            if (isPossible) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static boolean f(int[] nums, int mid, int k, int m) {
        int numBouquets = 0, countOfBloomedFlowers = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                countOfBloomedFlowers++;
                if (countOfBloomedFlowers == k) {
                    countOfBloomedFlowers = 0;
                    numBouquets++;
                    if (numBouquets == m)
                        return true;
                }
            } else {
                countOfBloomedFlowers = 0;
            }
        }
        return numBouquets == m;
    }

    public static void main(String[] args) {
        int[] flowers = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3, m = 2;
        System.out.println(roseGarden(flowers.length, flowers, k, m));
    }
}
