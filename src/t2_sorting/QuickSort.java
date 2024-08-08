package t2_sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {7, 4, 1, 5, 3};
        System.out.println(Arrays.toString(quickSort(nums)));
    }

    public static int[] quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    static int partition(int[] nums, int low, int high) {
        int pivotElement = nums[low];
        int i = low, j = high;
        while (i < j) {
            while (i <= high && nums[i] <= pivotElement) {
                i++;
            }
            while (j >= low && nums[j] > pivotElement) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, low, j);
        return j;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void sort(int[] nums, int l, int r) {
        if (l < r) {
            int pivotInd = partition(nums, l, r);
            sort(nums, l, pivotInd - 1);
            sort(nums, pivotInd + 1, r);
        }
    }
}
