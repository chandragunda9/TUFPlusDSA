package sorting;

public class SelectionSort {
    public int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minInd = findMinElementInd(nums, i);
            swap(nums, minInd, i);
        }
        return nums;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    int findMinElementInd(int[] arr, int startInd) {
        int minInd = startInd;
        for (int i = startInd + 1; i < arr.length; i++) {
            if (arr[i] < arr[minInd]) {
                minInd = i;
            }
        }
        return minInd;
    }
}
