package binary_search.on_answers;

import java.util.Arrays;

public class PaintersPartition {
    public int paint(int A, int B, int[] C) {
        long low = Arrays.stream(C).max().getAsInt();
        long high = 0;
        for (int i = 0; i < C.length; i++) {
            high += C[i];
        }
        while (low <= high) {
            long mid = (low + (high - low) / 2);
            if (canPaint(C, mid, A)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ((low * B) % 10000003);
    }

    boolean canPaint(int[] lens, long mid, int A) {
        int painters = 1;
        long total = 0;
        for (int i = 0; i < lens.length; i++) {
            if (total + lens[i] > mid) {
                painters++;
                total = 0;
                if (painters > A)
                    return false;
            }
            total += lens[i];
        }
        return true;
    }
}
