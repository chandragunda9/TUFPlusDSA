package t1_beginner_problems.basic_maths;

public class ReverseNumber {
    public int reverseNumber(int n) {
        int reversedNumber = 0;
        while (n > 0) {
            int rem = n % 10;
            reversedNumber = reversedNumber * 10 + rem;
            n /= 10;
        }
        return reversedNumber;
    }
}
