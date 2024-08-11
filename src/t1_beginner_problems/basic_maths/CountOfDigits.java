package t1_beginner_problems.basic_maths;

public class CountOfDigits {
    public int countDigit(int n) {
//        if (n == 0)
//            return 1;
//        int count = 0;
//        while (n > 0) {
//            n /= 10;
//            count++;
//        }
//        return count;
        if (n == 0)
            return 1;
        return (int) (Math.log10(n) + 1);
    }
}
