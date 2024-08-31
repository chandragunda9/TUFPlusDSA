package t6_recursion.implementation_problems;

public class PowerOfXAndN {
    public double method3(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= x;
        }
        return ans;
    }

    public double method1(double x, int n) {
        return Math.pow(x, n);
    }

    public double method2(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        if (n < 0)
            return method2((double) 1 / x, -n);
        double res = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                res = res * x;
            }
            n >>= 1;
            x = x * x;
        }
        return res;
    }

    public static double myPow(double x, int n) {
        return findPow(x, n);
    }

    public static double findPow(double x, long n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        if (n < 0) {
            return findPow(1 / x, -1 * n);
        }
        if ((n & 1) != 0) {
            return x * findPow(x, n - 1);
        }
        return findPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        int n = Integer.MIN_VALUE;
        System.out.println(n);
        double x = 2.000;
        System.out.println(myPow(x, n));
    }
}
