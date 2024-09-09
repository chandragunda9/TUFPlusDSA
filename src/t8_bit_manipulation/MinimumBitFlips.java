package t8_bit_manipulation;

public class MinimumBitFlips {
    public int minBitsFlip(int start, int goal) {
        int ans = start ^ goal;
        int count = 0;
        while (ans > 0) {
            if ((ans & 1) != 0) {
                count++;
            }
            ans >>= 1;
        }
        return count;
    }

    public int method1(int start, int goal) {
        int ans = start ^ goal;
        int count = 0;
        for (int i = 0; i < 31; i++) {
            if ((ans & (1 << i)) != 0)
                count++;
        }
        return count;
    }

    public int method2(int start, int goal) {
        int ans = start ^ goal;
        int count = 0;
        while (ans > 0) {
            ans = ans & (ans - 1);
            count++;
        }
        return count;
    }
}
