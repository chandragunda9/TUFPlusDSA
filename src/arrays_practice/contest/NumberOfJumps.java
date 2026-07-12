package arrays_practice.contest;

import java.util.ArrayList;
import java.util.List;

public class NumberOfJumps {
    public int NumberOfJumps(int[] nums, int k) {
        return mergeSort(nums, 0, nums.length - 1, k);
    }

    void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    int countJumps(int[] nums, int low, int mid, int high, int k) {
        int j = mid + 1, count = 0;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] + k >= nums[j]) {
                j++;
            }
            count += high - j + 1;
        }
        return count;
    }

    int mergeSort(int[] nums, int low, int high, int k) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += mergeSort(nums, low, mid, k);
            count += mergeSort(nums, mid + 1, high, k);
            count += countJumps(nums, low, mid, high, k);
            merge(nums, low, mid, high);
        }
        return count;
    }
}
