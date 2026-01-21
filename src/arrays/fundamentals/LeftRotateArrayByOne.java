package arrays.fundamentals;

public class LeftRotateArrayByOne {
    public void rotateArrayByOne(int[] nums) {
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = temp;
    }
    public void rotateArrayByOne1(int[] nums) {
        reverseArray(nums, 1, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverseArray(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
