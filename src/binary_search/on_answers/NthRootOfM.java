package binary_search.on_answers;

public class NthRootOfM {
    public int NthRoot1(int N, int M) {
        int low = 1, high = M;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long cmp = compare(mid, N, M);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static int compare(int mid, int N, int M) {
        long ans = 1;
        for (int i = 1; i <= N; i++) {
            ans = ans * mid;
            if (ans > M)
                return 1;
        }
        return ans == M ? 0 : -1;
    }

    public int NthRoot(int N, int M) {
        int low = 1, high = M;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = helperFun(mid, N, M);
            if (cmp == 0)
                return mid;
            else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static int helperFun(int mid, int N, int M) {
        long base = mid, exp = N, ans = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                exp--;
                ans = ans * base;
                if (ans > M)
                    return 1;
            } else {
                exp /= 2;
                base = base * base;
                if (base > M)
                    return 1;
            }
        }
        return ans < M ? -1 : 0;
    }
}
