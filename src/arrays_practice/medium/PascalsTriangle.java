package arrays_practice.medium;

public class PascalsTriangle {
    public int pascalTriangleI(int r, int c) {
        return nCr(r - 1, c - 1);
    }

    int nCr(int n, int r) {
        if (r > n - r)
            return nCr(n, n - r);
        int mul = 1;
        for (int i = 0; i < r; i++) {
            mul = mul * (n - i) / (i + 1);
        }
        return mul;
    }
}
