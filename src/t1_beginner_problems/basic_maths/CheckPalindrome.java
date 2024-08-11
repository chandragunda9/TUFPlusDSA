package t1_beginner_problems.basic_maths;

public class CheckPalindrome {
    public boolean isPalindrome(int n) {
        int copyN = n, reversedNo = 0;
        while (n > 0) {
            int rem = n % 10;
            reversedNo = reversedNo * 10 + rem;
            n /= 10;
        }
        return reversedNo == copyN;
    }
}
