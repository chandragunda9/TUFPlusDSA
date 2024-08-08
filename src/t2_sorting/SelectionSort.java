package t2_sorting;

import java.util.Arrays;

public class SelectionSort {

    public int[] selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minInd = selectElementAtMinInd(nums, i);
            swap(nums, i, minInd);
        }
        return nums;
    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    int selectElementAtMinInd(int[] nums, int ind) {
        int minInd = ind;
        for (int j = ind + 1; j < nums.length; j++) {
            if (nums[j] < nums[minInd]) {
                minInd = j;
            }
        }
        return minInd;
    }
}
