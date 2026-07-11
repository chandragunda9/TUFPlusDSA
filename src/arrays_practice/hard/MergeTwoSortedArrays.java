package arrays_practice.hard;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = 0;
        while (i >= 0 && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                swap(nums1, nums2, i, j);
                i--;
                j++;
            } else break;
        }
        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);
        for (int k = 0; k < nums2.length; k++) {
            nums1[m + k] = nums2[k];
        }
    }

    void swap(int[] nums1, int[] nums2, int i, int j) {
        int temp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = temp;
    }
}
