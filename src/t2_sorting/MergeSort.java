package t2_sorting;

public class MergeSort {
    public int[] mergeSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] lhalf = new int[n1], rhalf = new int[n2];
        for (int i = 0; i < n1; i++) {
            lhalf[i] = nums[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rhalf[i] = nums[mid + 1 + i];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (lhalf[i] <= rhalf[j]) {
                nums[k++] = lhalf[i++];
            } else {
                nums[k++] = rhalf[j++];
            }
        }
        while (i < n1) {
            nums[k++] = lhalf[i++];
        }
        while (j < n2) {
            nums[k++] = rhalf[j++];
        }
    }

    void sort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid);
            sort(nums, mid + 1, right);
            //merging sorted left and sorted right subarrays
            merge(nums, left, mid, right);
        }
    }
}
