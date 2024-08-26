package t5_binary_search.faqs;

import java.util.*;

public class AggressiveCows {
    public int aggressiveCows(int[] nums, int k) {
        Set<Integer> pos = new HashSet<>();
        for (int ele : nums) {
            pos.add(ele);
        }
        List<Integer> li = new ArrayList<>(pos);
        int[] positions = li.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(positions);
        int n = positions.length;
        int minVal = positions[0], maxVal = positions[n - 1];
        int maxDist = maxVal - minVal, minDist = maxDist;
        for (int i = 1; i < n; i++) {
            minDist = Math.min(minDist, positions[i] - positions[i - 1]);
        }
        int low = minDist, high = maxDist;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(positions, mid, k)) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return high;
    }

    boolean isPossible(int[] nums, int dist, int k) {
        int cowsPlaced = 1, last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last >= dist) {
                cowsPlaced++;
                last = nums[i];
            }
            if (cowsPlaced >= k)
                return true;
        }
        return false;
    }

    public int method1(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int minVal = nums[0], maxVal = nums[n - 1];
        int maxDist = maxVal - minVal;
        int minDist = maxDist;
        for (int i = 1; i < n; i++) {
            minDist = Math.min(minDist, nums[i] - nums[i - 1]);
        }
        int dist;
        for (dist = minDist; dist <= maxDist; dist++) {
            if (!isPossible(nums, dist, k)) {
                return dist - 1;
            }
        }
        return dist - 1;
    }

    public static void main(String[] args) {
        int n = 5, k = 3;
        int[] arr = {10, 1, 2, 7, 5};
        AggressiveCows obj = new AggressiveCows();
        System.out.println(obj.method1(arr, k));
        System.out.println(obj.aggressiveCows(arr, k));
    }
}
