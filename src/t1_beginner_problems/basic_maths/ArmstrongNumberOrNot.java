package t1_beginner_problems.basic_maths;

public class ArmstrongNumberOrNot {
    int countDigits(int n) {
        if (n == 0)
            return 1;
        return (int) (Math.log10(n) + 1);
    }

    public boolean isArmstrong(int n) {
        int noOfDigits = countDigits(n);
        int copyN = n, sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            sum += Math.pow(lastDigit, noOfDigits);
            n /= 10;
        }
        return sum == copyN;
    }
}
