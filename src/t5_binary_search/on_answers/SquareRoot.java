package t5_binary_search.on_answers;

public class SquareRoot {
    public long floorSqrt(long n) {
        if (n == 0)
            return 0;
        long low = 1, high = n;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (mid * mid <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
