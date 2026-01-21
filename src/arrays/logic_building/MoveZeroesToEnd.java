package arrays.logic_building;

public class MoveZeroesToEnd {
    public void moveZeroes(int[] nums) {
        int zeroPointer = 0;
        int nonZeroPointer = 0;
        int n = nums.length;
        for (zeroPointer = 0; zeroPointer < n; zeroPointer++) {
            if (nums[zeroPointer] == 0)
                break;
        }

        for (nonZeroPointer = zeroPointer + 1; nonZeroPointer < n; nonZeroPointer++) {
            if (nums[nonZeroPointer] != 0) {
                int temp = nums[zeroPointer];
                nums[zeroPointer] = nums[nonZeroPointer];
                nums[nonZeroPointer] = temp;
                zeroPointer++;
            }
        }
    }
}
