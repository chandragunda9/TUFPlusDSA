package t3_arrays.logic_building;

public class MoveZeroesToEnd {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int zeroPointer = 0;
        for (zeroPointer = 0; zeroPointer < n; zeroPointer++) {
            if (nums[zeroPointer] == 0)
                break;
        }
        if (zeroPointer == n)
            return;
        for (int nonZeroPointer = zeroPointer + 1; nonZeroPointer < n; nonZeroPointer++) {
            if (nums[nonZeroPointer] != 0) {
                int temp = nums[zeroPointer];
                nums[zeroPointer] = nums[nonZeroPointer];
                nums[nonZeroPointer] = temp;
                zeroPointer++;
            }
        }
    }
}
