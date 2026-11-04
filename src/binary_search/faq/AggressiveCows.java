package binary_search.faq;

import java.util.Arrays;

public class AggressiveCows {
    public static int aggressiveCows1(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxDist = nums[n - 1] - nums[0];
        //Linear search
        for (int dist = 1; dist <= maxDist; dist++) {
            if (!canPlaceCows(nums, k, dist))
                return dist - 1;
        }
        return maxDist;
    }

    public static int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxDist = nums[n - 1] - nums[0], minDist = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDist = Math.min(minDist, nums[i] - nums[i - 1]);
        }
        int low = minDist, high = maxDist;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean isPossible = canPlaceCows(nums, k, mid);
            if (isPossible) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    static boolean canPlaceCows(int[] nums, int k, int mid) {
        int cows = 1, prevPos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[prevPos] >= mid) {
                cows++;
                if (cows == k) {
                    return true;
                }
                prevPos = i;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 3, 6};
        int k = 2;
        System.out.println(aggressiveCows1(nums, k));
    }
}
