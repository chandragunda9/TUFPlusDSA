package GFGProblems.bits;

public class DivideTwoIntegers {
    public static long divide(long a, long b) {
        boolean isPositive = true;
        if (a > 0 && b < 0)
            isPositive = false;
        if (a < 0 && b > 0)
            isPositive = false;

        long dividend = Math.abs(a), divisor = Math.abs(b), count = 0;
        while (dividend >= divisor) {
            int exp = 0;
            while (dividend >= (divisor << exp)) {
                exp++;
            }
            exp -= 1;
            dividend = dividend - (divisor << exp);
            count = count + (1L << exp);
        }
        return isPositive ? count : -count;
    }

    public static void main(String[] args) {
        long a = 43, b = -8;
        System.out.println(divide(a, b));
    }
}
