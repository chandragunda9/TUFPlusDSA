package hashing.faq;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(longestSubarray1(arr, k));
    }

    public int longestSubarray(int[] nums, int k) {
        //positives+negatives
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0, ans = 0;
        sumMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumMap.containsKey(sum - k)) {
                int endInd = sumMap.get(sum - k);
                ans = Math.max(ans, i - endInd);
            }
            if (!sumMap.containsKey(sum)) sumMap.put(sum, i);
        }
        return ans;
    }

    public static int longestSubarray1(int[] nums, int k) {
        //only positives
        int i = 0, j = 0;
        int sum = 0;
        int ans = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (i <= j && sum > k) {
                sum -= nums[i];
                i++;
            }
            if (sum == k) {
                ans = Math.max(ans, j - i + 1);
            }
            j++;
        }
        return ans;
    }
}
