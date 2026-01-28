package arrays.hard;

public class RepeatingAndMissingNumber {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
            xor ^= i + 1;
        }
        //now we got XOR which is non zero
//        int pos = 0;
//        while ((xor & (1 << pos)) == 0) {
//            pos++;
//        }
        int val = xor & -xor;
        int zeroes = 0;
        int ones = 0;
        for (int i = 0; i < n; i++) {
//            if ((nums[i] & (1 << pos)) != 0) {
            if ((nums[i] & val) != 0) {
                ones ^= nums[i];
            } else {
                zeroes ^= nums[i];
            }
        }
        for (int i = 1; i <= n; i++) {
//            if ((i & (1 << pos)) != 0) {
            if ((i & val) != 0) {
                ones ^= i;
            } else {
                zeroes ^= i;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == zeroes) {
                count += 1;
                if (count == 2) break;
            }
        }
        if (count == 2) {
            return new int[]{zeroes, ones};
        }
        return new int[]{ones, zeroes};
    }
}
