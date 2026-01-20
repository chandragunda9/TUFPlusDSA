package sorting;

public class InsertionSort {
    public int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int temp = nums[i];
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
}
