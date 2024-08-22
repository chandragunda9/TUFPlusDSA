package t3_arrays.easy;

public class LeftRotateAnArray {
    public void rotateArrayByOne(int[] nums) {
        int t = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = t;
    }
}
