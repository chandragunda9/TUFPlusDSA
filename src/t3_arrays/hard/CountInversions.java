package t3_arrays.hard;

public class CountInversions {
    public long numberOfInversions(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    long merge(int[] nums, int l, int m, int r) {
        int[] lhalf = new int[m - l + 1];
        int[] rhalf = new int[r - m];
        int n1 = lhalf.length, n2 = rhalf.length;
        for (int i = 0; i < n1; i++) {
            lhalf[i] = nums[l + i];
        }
        for (int i = 0; i < n2; i++) {
            rhalf[i] = nums[m + 1 + i];
        }
        int k = l, i = 0, j = 0;
        long count = 0;
        while (i < n1 && j < n2) {
            if (lhalf[i] <= rhalf[j]) {
                nums[k++] = lhalf[i++];
            } else {
                count += (n1 - i);
                nums[k++] = rhalf[j++];
            }
        }
        while (i < n1) {
            nums[k++] = lhalf[i++];
        }
        while (j < n2) {
            nums[k++] = rhalf[j++];
        }
        return count;
    }

    long mergeSort(int[] nums, int l, int r) {
        long noOfInversions = 0;
        if (l < r) {
            int mid = (l + r) / 2;
            noOfInversions += mergeSort(nums, l, mid);
            noOfInversions += mergeSort(nums, mid + 1, r);
            noOfInversions += merge(nums, l, mid, r);
        }
        return noOfInversions;
    }
}
