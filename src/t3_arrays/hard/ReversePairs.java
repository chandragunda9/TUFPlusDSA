package t3_arrays.hard;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    void merge(int[] nums, int l, int mid, int r) {
        int m = mid - l + 1, n = r - mid;
        int[] lhalf = new int[m];
        int[] rhalf = new int[n];
        for (int i = 0; i < m; i++) {
            lhalf[i] = nums[l + i];
        }
        for (int i = 0; i < n; i++) {
            rhalf[i] = nums[mid + 1 + i];
        }
        int i = 0, j = 0, k = l;
        while (i < m && j < n) {
            if (lhalf[i] <= rhalf[j]) {
                nums[k++] = lhalf[i++];
            } else {
                nums[k++] = rhalf[j++];
            }
        }
        while (i < m) {
            nums[k++] = lhalf[i++];
        }
        while (j < n) {
            nums[k++] = rhalf[j++];
        }
    }

    int countReversePairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] > 2 * nums[right])
                right++;
            count += (right - (mid + 1));
        }
        return count;
    }

    int mergeSort(int[] nums, int l, int r) {
        int count = 0;
        if (l < r) {
            int mid = (l + r) / 2;
            count += mergeSort(nums, l, mid);
            count += mergeSort(nums, mid + 1, r);
            count += countReversePairs(nums, l, mid, r);
            merge(nums, l, mid, r);
        }
        return count;
    }
}
