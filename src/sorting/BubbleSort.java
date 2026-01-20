package sorting;

public class BubbleSort {
    public int[] bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            boolean swapDone = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapDone = true;
                }
            }
            if (!swapDone) {
                break;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
