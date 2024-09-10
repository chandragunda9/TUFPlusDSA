package GFGProblems.bits;

import java.util.Arrays;

public class SingleNumberII {
    static int method1(int[] arr, int N) {
        Arrays.sort(arr);
        for (int i = 1; i < N; i++) {
            if (arr[i] != arr[i - 1]) {
                return arr[i - 1];
            }
        }
        return arr[N - 1];
    }

    static int method2(int[] arr, int N) {
        int ans = 0;
        for (int bitIndex = 0; bitIndex < 31; bitIndex++) {
            int count = 0;
            for (int ind = 0; ind < N; ind++) {
                if ((arr[ind] & (1 << bitIndex)) != 0)
                    count++;
            }
            if (count % 3 != 0) {
                ans = ans | (1 << bitIndex);
            }
        }
        return ans;
    }

    static int singleElement(int[] arr, int N) {
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < N; i++) {
            ones = (ones ^ arr[i]) & ~twos;
            twos = (twos ^ arr[i]) & ~ones;
        }
        return ones;
    }
}
