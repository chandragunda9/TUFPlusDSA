package arrays_practice.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElementI {
    public int majorityElement(int[] nums) {
        // By using moore's voting algorithm
        int count = 0;
        int ele = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ele = nums[i];
                count = 1;
            } else if (ele == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return ele;
    }

    public int majorityElement1(int[] nums) {
        //By using streams
        return Arrays.stream(nums).boxed().collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                )
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }
}
