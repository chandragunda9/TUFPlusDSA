package t3_arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    int mod = (int) (1e9 + 7);

    public List<List<Integer>> pascalTriangle(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> ithRow = getIthRow(i);
            ans.add(ithRow);
        }
        return ans;
    }

    List<Integer> getIthRow(int row) {
        List<Integer> values = new ArrayList<>();
        values.add(1);
        int mul = 1;
        for (int col = 1; col < row; col++) {
            mul = mul * (row - col) / col;
            values.add(mul);
        }
//        for (int col = 1; col < row; col++) {
//            mul = mul * (row - col) % mod;
//            mul = mul * (int) modInverse(col, mod) % mod;
//            values.add(mul);
//        }
        return values;
    }

    long modInverse(int a, int mod) {
        return power(a, mod - 2, mod);
    }

    long power(int x, int y, int mod) {
        x = x % mod;
        long res = 1;
        while (y > 0) {
            if ((y & 1) != 0) {
                res = (res * x) % mod;
            }
            y >>= 1;
            x = (x * x) % mod;
        }
        return res;
    }
}
