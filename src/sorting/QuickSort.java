package sorting;

public class QuickSort {
    public int[] quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    int findPartition(int[] nums, int low, int high) {
        int left = low, right = high;
        while (left < right) {
            while (left <= high && nums[left] <= nums[low]) {
                left++;
            }
            while (right >= low && nums[right] > nums[low]) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        int temp = nums[right];
        nums[right] = nums[low];
        nums[low] = temp;
        return right;
    }

    void sort(int[] nums, int low, int high) {
        if (low < high) {
            int partitionInd = findPartition(nums, low, high);
            sort(nums, low, partitionInd - 1);
            sort(nums, partitionInd + 1, high);
        }
    }
}
