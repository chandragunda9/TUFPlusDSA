package arrays.fundamentals;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargestElement {
    public int secondLargestElement1(int[] nums) {
        int maxEle = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > maxEle) {
                secondMax = maxEle;
                maxEle = num;
            } else if (num != maxEle && num > secondMax) {
                secondMax = num;
            }
        }
        return secondMax == Integer.MIN_VALUE ? -1 : secondMax;
    }

    public int secondLargestElement(int[] nums) {
        return Arrays.stream(nums).distinct().boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
    }
}
