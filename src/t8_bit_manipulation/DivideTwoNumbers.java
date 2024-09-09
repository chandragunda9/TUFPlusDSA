package t8_bit_manipulation;

public class DivideTwoNumbers {
    public static int method1(int dividend, int divisor) {
        boolean isPositive = true;
        if (dividend > 0 && divisor < 0)
            isPositive = false;
        if (dividend < 0 && divisor > 0)
            isPositive = false;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int sum = 0, count = 0;
        while (sum + divisor <= dividend) {
            sum += divisor;
            count++;
        }
        return isPositive ? count : -count;
    }

    public static int divide(int dividend, int divisor) {
        boolean isPositive = true;
        if (dividend > 0 && divisor < 0)
            isPositive = false;
        if (dividend < 0 && divisor > 0)
            isPositive = false;

        int val = Math.abs(dividend);
        int div = Math.abs(divisor);

        int ans = 0;
        while (val >= div) {
            int exp = 0;
//            while (val >= div * Math.pow(2, exp)) {
            while (val >= (div << exp)) {
                exp++;
            }
            exp--;
//            ans += (int) Math.pow(2, exp);
            ans += (1 << exp);
//            val -= div * (int) Math.pow(2, exp);
            val -= div << exp;
        }
        return isPositive ? ans : -ans;
    }

    public static void main(String[] args) {
        int n = 10, x = 3;
        System.out.println(method1(n, x));
        System.out.println(divide(n, x));
    }
}
