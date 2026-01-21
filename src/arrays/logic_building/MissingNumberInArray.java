package arrays.logic_building;

public class MissingNumberInArray {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
            xor ^= (i + 1);
        }
        return xor;
    }
}
