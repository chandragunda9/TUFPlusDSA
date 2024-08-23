package t3_arrays.fundamentals;

public class SecondLargestElement {
    public int secondLargestElement(int[] nums) {
        int largest = Integer.MIN_VALUE, sLargest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                sLargest = largest;
                largest = nums[i];
            } else if (nums[i] > sLargest && nums[i] < largest) {
                sLargest = nums[i];
            }
        }
        return sLargest != Integer.MIN_VALUE ? sLargest : -1;
    }
}
