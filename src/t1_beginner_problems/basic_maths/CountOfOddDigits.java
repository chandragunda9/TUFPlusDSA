package t1_beginner_problems.basic_maths;

public class CountOfOddDigits {
    public int countOddDigit(int n) {
        int noOfOddDigits = 0;
        while (n > 0) {
            int rem = n % 10;
            if ((rem & 1) != 0)
                noOfOddDigits++;
            n /= 10;
        }
        return noOfOddDigits;
    }
}
