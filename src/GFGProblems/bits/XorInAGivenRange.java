package GFGProblems.bits;

public class XorInAGivenRange {
    public int getXor(int[] nums, int a, int b) {
        int xor = 0;
        for (int i = a; i <= b; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}
