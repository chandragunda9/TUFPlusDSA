package sorting;

public class QuickSort {
    public int[] quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    int findPivotElement(int[] nums, int low, int high) {
        int i = low, j = high;
        while (i < j) {
            while (i <= high && nums[i] <= nums[low]) {
                i++;
            }
            while (j >= low && nums[j] > nums[low]) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, low, j);
        return j;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void sort(int[] nums, int low, int high) {
        if (low < high) {
            int partitionIndex = findPivotElement(nums, low, high);
            sort(nums, low, partitionIndex - 1);
            sort(nums, partitionIndex + 1, high);
        }
    }
}
