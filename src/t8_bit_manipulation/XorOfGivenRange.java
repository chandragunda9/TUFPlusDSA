package t8_bit_manipulation;

public class XorOfGivenRange {
    public int findRangeXOR(int l, int r) {
        return xorTillRange(l - 1) ^ xorTillRange(r);
    }

    public int xorTillRange(int n) {
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        if (n % 4 == 3) return 0;
        return n;
    }
}
