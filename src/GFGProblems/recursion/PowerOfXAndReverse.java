package GFGProblems.recursion;

public class PowerOfXAndReverse {
    long method1(int N, int R) {
        int mod = 1000000007;
        long res = 1;
        while (R > 0) {
            if ((R & 1) != 0) {
                res = (res * N) % mod;
            }
            R >>= 1;
            //below commented one not working because of integer overflow in multiplication
            // N = (N * N) % mod;
            N = (int) (((long) N * N) % mod);
        }
        return res;
    }

    long power(int N, int R) {
        int mod = (int) (1e9 + 7);
        if (R == 0)
            return 1;
        if (N == 1)
            return 1;
        int square = (int) (((long) N * N) % mod);
        long res = 1;
        if ((R & 1) != 0) {
            res = (res * N) % mod;
        }
        R >>= 1;
        return res * power(square, R) % mod;
    }

    public static void main(String[] args) {
        int n = (int) (1e9 + 7);
        //below cannot be done, because integer value above is large and in multiplication it causes overflow
        long x = n * n;
        System.out.println(n * n);
        System.out.println(x);
    }
}
