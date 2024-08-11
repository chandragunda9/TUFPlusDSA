package t1_beginner_problems.basic_maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivisorsOfNumber {
    public int[] divisors(int n) {
        List<Integer> temp = new ArrayList<>();
        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                temp.add(i);
                if (i != n / i)
                    temp.add(n / i);
            }
        }
        Collections.sort(temp);
        /*Time Complexity:
            The overall time complexity is the sum of the time complexities of the loop and the sorting step:
            Loop: O(√n)
            Sorting: O(√n log √n)
            Since O(√n log √n) dominates O(√n), the overall time complexity is:
            O(√n log √n) - This is the time complexity of the entire code block.

           Space Complexity: O(sqrt(N)) – A number N can have at max 2*sqrt(N) divisors, which are stored in the array.
        * */
        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
}
