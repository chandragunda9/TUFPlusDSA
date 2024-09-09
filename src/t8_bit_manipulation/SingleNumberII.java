package t8_bit_manipulation;

import java.util.Arrays;

public class SingleNumberII {
    public int method2(int[] nums) {
        int ans = 0;
        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & (1 << bitIndex)) != 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                ans = ans | (1 << bitIndex);
            }
        }
        return ans;
        //Time : O(31*N)
        //Space: O(1)
    }

    public int method3(int[] nums) {
        //sort the array
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 3) {
            if (nums[i] != nums[i - 1])
                return nums[i - 1];
        }
        return nums[nums.length - 1];
    }


    //method4
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 3};
        SingleNumberII obj = new SingleNumberII();
        System.out.println(obj.singleNumber(arr));
    }
}
