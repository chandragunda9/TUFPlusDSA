package arrays.fundamentals;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MaximumConsecutiveOnes {
    public int findMaxConsecutiveOnes1(int[] nums) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        return Arrays.stream(nums).map(num -> num == 1 ? atomicInteger.incrementAndGet() : atomicInteger.getAndSet(0))
                .max().getAsInt();
    }


    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            count = nums[i] == 1 ? count + 1 : 0;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
