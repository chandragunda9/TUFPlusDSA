package arrays.medium;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 7};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {
        int breakPoint = -1, n = nums.length;
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                breakPoint = i - 1;
                break;
            }
        }
        if (breakPoint == -1) {
            reverseArray(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > breakPoint; i--) {
            if (nums[i] > nums[breakPoint]) {
                int temp = nums[i];
                nums[i] = nums[breakPoint];
                nums[breakPoint] = temp;
                break;
            }
        }

        reverseArray(nums, breakPoint + 1, n - 1);
    }

    static void reverseArray(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
