package t8_bit_manipulation;

import java.util.Arrays;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int ones = 0, zeroes = 0;
        int bitNo = (xor & (xor - 1)) ^ xor; //bitValue
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & bitNo) != 0) {
                ones ^= nums[i];
            } else {
                zeroes ^= nums[i];
            }
        }
        int[] ans = new int[2];
        ans[0] = zeroes;
        ans[1] = ones;
        Arrays.sort(ans);
        return ans;
    }
}
