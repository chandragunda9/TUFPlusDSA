package GFGProblems.bits;

public class CountBitsFlip {
    public static int countBitsFlip(int a, int b) {
        int val = a ^ b;
        int count = 0;
        while (val > 0) {
            val = val & val - 1;
            count++;
        }
        return count;
    }

    public static int method1(int a, int b) {
        int val = a ^ b;
        int count = 0;
        while (val > 0) {
            if ((val & 1) != 0) {
                count++;
            }
            val >>= 1;
        }
        return count;
    }
}
