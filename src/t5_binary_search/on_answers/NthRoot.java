package t5_binary_search.on_answers;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NthRoot {
    int f(int n, int m, int mid) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= mid;
            if (ans > m)
                return 2;
        }
        if (ans == m)
            return 1;
        return 0;
//        return power(new BigInteger(String.valueOf(mid)), n, new BigInteger(String.valueOf(m)));
    }

    int power(BigInteger x, int y, BigInteger number) {
        BigInteger res = new BigInteger("1");
        while (y > 0) {
            if ((y & 1) != 0) {
                res = res.multiply(x);
                if (res.compareTo(number) > 0)
                    return 2;
            }
            y >>= 1;
            x = x.multiply(x);
        }
        if (res.equals(number))
            return 1;
        return 0;
    }

    public int NthRoot(int N, int M) {
        int low = 1, high = M;
        while (low <= high) {
            int mid = (low + high) / 2;
            int res = f(N, M, mid);
            if (res == 1)
                return mid;
            else if (res == 2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NthRoot obj = new NthRoot();
        int N = 9, M = 1953125;
        BigDecimal b1 = new BigDecimal("50.1");
        BigDecimal b2 = new BigDecimal("50.12");
        BigDecimal b3 = new BigDecimal(50);
        BigInteger b4 = new BigInteger(String.valueOf(50));
        System.out.println(b1.equals(b2));
        System.out.println(obj.NthRoot(N, M));
    }
}
