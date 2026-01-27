package arrays.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeadersInArray {
    public List<Integer> leaders(int[] nums) {
        int rightMax = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > rightMax) {
                ans.add(nums[i]);
                rightMax = nums[i];
            }
        }
        return IntStream.range(0, ans.size()).mapToObj(i -> ans.get(ans.size() - i - 1)).collect(Collectors.toList());
    }
}
