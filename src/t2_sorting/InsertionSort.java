package t2_sorting;

public class InsertionSort {
    public int[] insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int j = i, temp = nums[i];
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j = j - 1;
            }
            nums[j] = temp;
        }
        return nums;
    }
}
