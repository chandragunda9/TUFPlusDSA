package arrays.fundamentals;

import java.util.stream.IntStream;

public class LinearSearch {
    public int linearSearch2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }

    public int linearSearch(int[] nums, int target) {
        return IntStream.range(0, nums.length).filter(i -> nums[i] == target).findFirst().orElse(-1);
    }
}
