package arrays.fundamentals;

import java.util.Arrays;

public class LargestElementInArray {
    public int largestElement(int[] nums) {
        return Arrays.stream(nums).max().getAsInt();
    }
}
