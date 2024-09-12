package t3_arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElementTwo(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && nums[i] != ele2) {
                ele1 = nums[i];
                count1 = 1;
            } else if (count2 == 0 && nums[i] != ele1) {
                ele2 = nums[i];
                count2 = 1;
            } else if (ele1 == nums[i]) {
                count1++;
            } else if (ele2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == ele1)
                count1++;
            else if (nums[i] == ele2)
                count2++;
        }
        if (count1 > n / 3)
            ans.add(ele1);
        if (count2 > n / 3)
            ans.add(ele2);
        return ans;
    }

    public List<Integer> findMajority(List<Integer> nums) {
        List<Integer> ans = new ArrayList<>();
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0, n = nums.size();
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && nums.get(i) != ele2) {
                ele1 = nums.get(i);
                count1 = 1;
            } else if (count2 == 0 && nums.get(i) != ele1) {
                ele2 = nums.get(i);
                count2 = 1;
            } else if (ele1 == nums.get(i)) {
                count1++;
            } else if (ele2 == nums.get(i)) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == ele1)
                count1++;
            else if (nums.get(i) == ele2)
                count2++;
        }
        if (count1 > n / 3)
            ans.add(ele1);
        if (count2 > n / 3)
            ans.add(ele2);
        return ans.isEmpty() ? List.of(-1) : ans;
    }
}
