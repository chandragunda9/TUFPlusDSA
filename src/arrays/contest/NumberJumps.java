package arrays.contest;


public class NumberJumps {
    public int NumberOfJumps(int[] nums, int k) {
        return mergeSort(nums, 0, nums.length - 1, k);
    }

    void merge(int[] nums, int low, int mid, int high) {
        int left = low, right = mid + 1;
        int[] temp = new int[high - low + 1];
        int t = 0;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[t++] = nums[left++];
            } else {
                temp[t++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[t++] = nums[left++];
        }

        while (right <= high) {
            temp[t++] = nums[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }

    int mergeSort(int[] nums, int low, int high, int k) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += mergeSort(nums, low, mid, k);
            count += mergeSort(nums, mid + 1, high, k);

            //count logic
            int j = mid + 1;
            for (int i = low; i <= mid; i++) {
                while (j <= high && nums[i] + k >= nums[j]) {
                    j++;
                }
                count += (high - j + 1);
            }

            merge(nums, low, mid, high);
        }
        return count;
    }
}
