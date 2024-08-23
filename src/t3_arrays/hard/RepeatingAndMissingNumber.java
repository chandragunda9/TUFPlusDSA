package t3_arrays.hard;

public class RepeatingAndMissingNumber {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int xor = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int bitNo = 0;
        while (true) {
            if ((xor & (1 << bitNo)) != 0)
                break;
            bitNo++;
        }
        int ones = 0, zero = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & (1 << bitNo)) != 0) {
                ones ^= nums[i];
            } else {
                zero ^= nums[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & (1 << bitNo)) != 0) {
                ones ^= i;
            } else {
                zero ^= i;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == zero)
                count++;
        }
        return count >= 2 ? new int[]{zero, ones} : new int[]{ones, zero};
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 1};
    }
}
