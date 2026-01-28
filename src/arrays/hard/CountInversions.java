package arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {
    public long numberOfInversions(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    long merge(int[] nums, int low, int mid, int high) {
        long count = 0;
        int i = low, j = mid + 1;
        List<Integer> temp = new ArrayList<>();
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp.add(nums[i]);
                i++;
            } else {
                temp.add(nums[j]);
                j++;
                count += (mid - i + 1);
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
        return count;
    }

    long mergeSort(int[] nums, int low, int high) {
        long count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += mergeSort(nums, low, mid);
            count += mergeSort(nums, mid + 1, high);
            count += merge(nums, low, mid, high);
        }
        return count;
    }
}
