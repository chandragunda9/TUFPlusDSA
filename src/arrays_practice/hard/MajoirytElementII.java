package arrays_practice.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajoirytElementII {
    public List<Integer> majorityElementTwo(int[] nums) {
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && ele2 != nums[i]) {
                ele1 = nums[i];
                count1 = 1;
            } else if (count2 == 0 && ele1 != nums[i]) {
                ele2 = nums[i];
                count2 = 1;
            } else if (nums[i] == ele1) {
                count1++;
            } else if (nums[i] == ele2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele1) {
                count1++;
            } else if (nums[i] == ele2) {
                count2++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (count1 > nums.length / 3) {
            ans.add(ele1);
        }
        if (count2 > nums.length / 3) {
            ans.add(ele2);
        }
        Collections.sort(ans);
        return ans;
    }
}
