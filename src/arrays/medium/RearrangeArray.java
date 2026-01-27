package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class RearrangeArray {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int pos = 0, neg = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                ans[neg] = nums[i];
                neg += 2;
            } else {
                ans[pos] = nums[i];
                pos += 2;
            }
        }
        return ans;
    }

    public int[] rearrangeArray1(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length / 2; i++) {
            nums[2 * i] = pos.get(i);
            nums[2 * i + 1] = neg.get(i);
        }
        return nums;
    }
}
