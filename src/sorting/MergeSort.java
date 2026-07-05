package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public int[] mergeSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int i = low, j = mid + 1;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp.add(nums[i]);
                i++;
            } else {
                temp.add(nums[j]);
                j++;
            }
        }
        while (i <= mid) {
            temp.add(nums[i]);
            i++;
        }
        while (j <= high) {
            temp.add(nums[j]);
            j++;
        }
        for (int k = low; k <= high; k++) {
            nums[k] = temp.get(k - low);
        }
    }

    void sort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(nums, low, mid);
            sort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }
}
