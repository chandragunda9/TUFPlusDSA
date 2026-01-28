package arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    void merge(int[] nums, int low, int mid, int high) {
        int i = low, j = mid + 1;
        List<Integer> temp = new ArrayList<>();
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
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

        for (int k = 0; k < temp.size(); k++) {
            nums[low + k] = temp.get(k);
        }
    }

    int countReversePairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for (int left = low; left <= mid; left++) {
            while (right <= high && nums[left] > 2L * nums[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    int mergeSort(int[] nums, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += mergeSort(nums, low, mid);
            count += mergeSort(nums, mid + 1, high);
            count += countReversePairs(nums, low, mid, high);
            merge(nums, low, mid, high);
        }
        return count;
    }
}
