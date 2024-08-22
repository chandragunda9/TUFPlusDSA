package t3_arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeadersInArray {
    public int[] leaders(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length, rightMax = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > rightMax) {
                ans.add(nums[i]);
                rightMax = nums[i];
            }
        }
        reverse(ans, 0, ans.size() - 1);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    void reverse(List<Integer> ans, int l, int r) {
        while (l < r) {
            int t = ans.get(l);
            ans.set(l, ans.get(r));
            ans.set(r, t);
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {-3, 4, 5, 1, -30, -10};
        LeadersInArray obj = new LeadersInArray();
        System.out.println(Arrays.toString(obj.leaders(arr)));
    }
}
