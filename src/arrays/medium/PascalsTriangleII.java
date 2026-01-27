package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public int[] pascalTriangleII(int r) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int mul = 1;
        for (int i = 1; i < r; i++) {
            mul = mul * (r - i) / i;
            ans.add(mul);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
