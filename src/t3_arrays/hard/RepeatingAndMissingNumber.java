package t3_arrays.hard;

import java.util.Arrays;

public class RepeatingAndMissingNumber {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int xor = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
//        int bitNo = 0;
//        while (true) {
//            if ((xor & (1 << bitNo)) != 0)
//                break;
//            bitNo++;
//        }

//        int number = xor & ~(xor - 1);
        int number = xor & -xor;
        int ones = 0, zero = 0;
        for (int i = 0; i < n; i++) {
//            if ((nums[i] & (1 << bitNo)) != 0) {
            if ((nums[i] & number) != 0) {
                ones ^= nums[i];
            } else {
                zero ^= nums[i];
            }
        }
        for (int i = 1; i <= n; i++) {
//            if ((i & (1 << bitNo)) != 0) {
            if ((i & number) != 0) {
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

    static int[] findTwoElement(int arr[]) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        for (int i = 1; i <= arr.length; i++) {
            xor ^= i;
        }

        int num = (xor & (xor - 1)) ^ xor;
        int ones = 0, zeroes = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & num) != 0) {
                ones ^= arr[i];
            } else {
                zeroes ^= arr[i];
            }
        }
        for (int i = 1; i <= arr.length; i++) {
            if ((i & num) != 0) {
                ones ^= i;
            } else {
                zeroes ^= i;
            }
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == zeroes)
                count++;
        }
        return count >= 2 ? new int[]{zeroes, ones} : new int[]{ones, zeroes};
    }

    public static void main(String[] args) {
        int[] arr = {2, 2};
        System.out.println(Arrays.toString(findTwoElement(arr)));
    }
}
