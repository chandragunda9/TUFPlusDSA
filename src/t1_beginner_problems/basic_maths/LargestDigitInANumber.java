package t1_beginner_problems.basic_maths;

public class LargestDigitInANumber {
    public int largestDigit(int n) {
        int largest = 0;
        while (n > 0) {
            int rem = n % 10;
            largest = Math.max(largest, rem);
            n /= 10;
        }
        return largest;
    }
}
